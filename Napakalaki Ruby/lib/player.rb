# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
  require_relative "treasure"
  require_relative "dice"
  require_relative "bad_consequence"
  require_relative "treasure_kind"
  require_relative "combat_result"

module NapakalakiGame


  class Player
    @@MAXLEVEL = 10
    @@INITIALLEVEL = 1

    def initialize(name)

      @name = name
      @level = @@INITIALLEVEL
      @dead = true
      @canISteal = true
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
      @pendingBadConsequence = nil
      @enemy = nil
    end
    
    def newCopy(p)
      np = new(p.getName)
      np.setVT Array.new p.getVT
      np.setHT Array.new p.getHT
      np.setLevel p.getLevels
      np.setDead p.isDead
      np.setCanI p.getCanI
      np.setEnemy p.getEnemy
      np.setPendingBadConsequence p.getPendingBadConsequence
      
      np
    end
    
    def self.MAXLEVEL
      @@MAXLEVEL
    end
    
    def to_s
      c_level = getCombatLevel
      "#{@name} \nNivel del jugador: #{@level}\nNivel de combate: #{c_level}"
    end
    
    def bringToLife
      @dead = false
    end

    def getCombatLevel
      clevel = @level
      @visibleTreasures.each { |trea| clevel += trea.getBonus }
      return clevel
    end
    
    def getOponentLevel m 
      m.getCombatLevel
    end
    
    def shouldConvert
     
      return true if(Dice.instance.nextNumber == 6)
      return false
    end
    

    def incrementLevels(i)
      if ((@level+i)>10)
        @level = 10
      else
        @level += i
      end    
    end

    def decrementLevels(i)
      if (i>=@level)
        @level = 1
      else
        @level -= i
      end
    end

 
    
    def applyPrize(m)
      incrementLevels(m.getLevelsGained)
      if (m.getTreasuresGained > 0)
        dealer = CardDealer.instance
        m.getTreasuresGained.times do 
          treasure = dealer.nextTreasure
          @hiddenTreasures << treasure
        end
      end
    end

    def applyBadConsequence(m)

      badConsequence = m.getBadConsequence
      nLevels = badConsequence.getLevels
      decrementLevels(nLevels)
      pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
      setPendingBadConsequence(pendingBad)
    end   
    
    def howManyVisibleTreasures(tKind)
      i = 0
      @visibleTreasures.each do |t|
        if (t.getType == tKind)
          i += 1
        end
      end 
      i
    end
    
    def dieIfNoTreasures
      if @visibleTreasures.empty? and @hiddenTreasures.empty?
      @dead = true
      end
    end
    
    def validState
      @hiddenTreasures.length <= 4 && (@pendingBadConsequence == nil || @pendingBadConsequence.isEmpty)      
    end 
    
    def isDead
      @dead
    end     
   
    def canISteal
      @canISteal
    end
      
    
    def getName
      @name
    end
     
    def getHiddenTreasures
      @hiddenTreasures
    end

    def getVisibleTreasures
      @visibleTreasures
    end

    def getLevels
      @level
    end
    
    def getEnemy
      @enemy
    end
    
    def getPendingBadConsequence
      @pendingBadConsequence
    end
    
    def setEnemy(enemy)
      @enemy = enemy
    end
    
    def setVT(vt)
      @visibleTreasures = vt
    end
    
    def setHT(ht)
      @hiddenTreasures = ht
    end
    
    def setPendingBadConsequence(b)
      @pendingBadConsequence = b
    end
    

    def canYouGiveMeATreasure
      return true if (@hiddenTreasures.size() > 0)
      return false
    end

    def haveStolen
      @canISteal = false
    end

   def canMakeTreasureVisible(t)
      
      if (t.getType != TreasureKind::ONEHAND && t.getType != TreasureKind::BOTHHANDS)
          return false if (treasureInUse(t.getType))
      return true
      else                                          
        una_mano = 0
        dos_manos = 0
        @visibleTreasures.each do |i|
          puts i
          una_mano += 1 if (TreasureKind::ONEHAND == i.getType)
          dos_manos += 1 if (TreasureKind::BOTHHANDS == i.getType)

        end
        if (una_mano == 0 && dos_manos == 0)                        
          return true
        end
      end
      return una_mano == 1 && t.getType() == TreasureKind::ONEHAND && dos_manos == 0;
    end
        
    def treasureInUse (type)
      @visibleTreasures.each do |i|
        if(type == i.getType)
          return true
        end
      end
      return false
    end

   def combat(m)
      myLevel = getCombatLevel
      monsterLevel = getOponentLevel m
      if (@canISteal == false)
        dice = Dice.instance
        number = dice.nextNumber
        if (number < 3)
          enemyLevel = @enemy.getCombatLevel
          monsterLevel += enemyLevel
        end
      end
      if (myLevel > monsterLevel)
        applyPrize(m)
        if (@level >= @@MAXLEVEL)
          combatResult = CombatResult::WINGAME
        else
          combatResult = CombatResult::WIN
        end
      else 
        applyBadConsequence(m)
        if(shouldConvert)
          combatResult = CombatResult::LOSEANDCONVERT
        else
          combatResult = CombatResult::LOSE
        end     
      end
      combatResult
    end
    
   def makeTreasureVisible(t)
      canI = canMakeTreasureVisible(t)
      if (canI)
        @visibleTreasures << t
        @hiddenTreasures.delete(t)
      end
    end

    def discardVisibleTreasure(t)
      @visibleTreasures.delete(t)
      if (@pendingBadConsequence != nil && @pendingBadConsequence.isEmpty() == false)
        @pendingBadConsequence.substractVisibleTreasure t
        if @pendingBadConsequence.getNVisibleTreasures == 0 && @pendingBadConsequence.getNHiddenTreasures == 0
          @pendingBadConsequence = nil
        end
      end
      
      dieIfNoTreasures
    end

    def discardHiddenTreasure(t)
      @hiddenTreasures.delete(t)
      if (@pendingBadConsequence != nil && @pendingBadConsequence.isEmpty() == false)
          @pendingBadConsequence.substractHiddenTreasure t
          if @pendingBadConsequence.nHiddenTreasures == 0 && @pendingBadConsequence.nVisibleTreasures != 0
          @pendingBadConsequence = nil
          end
      end
      dieIfNoTreasures
    end

    def initTreasures
      dealer = CardDealer.instance
      dice = Dice.instance
      bringToLife
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
      number = dice.nextNumber
      if (number > 1)
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure        
      end
      if (number == 6)
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end

    def stealTreasure
      canI = canISteal
      if (canI)
        if (@enemy.canYouGiveMeATreasure)
          treasure = @enemy.giveMeATreasure
          @hiddenTreasures << treasure
          haveStolen
        end
      else
        treasure = nil
      end
      return treasure
    end

    def giveMeATreasure
      indice = rand(@hiddenTreasures.size)
      tr = @hiddenTreasures[indice]
      @hiddenTreasures.delete_at(indice)
      return tr
    end

    def discardAllTreasures
      cVisible= Array.new(@visibleTreasures)
      cHidden = Array.new(@hiddenTreasures)
      cVisible.each do |treasure|
        discardVisibleTreasure(treasure)
      end
      cHidden.each do |treasure|
        discardHiddenTreasure(treasure)
      end
    end
    
  private :bringToLife, :incrementLevels, :decrementLevels, :setPendingBadConsequence, :applyPrize, :applyBadConsequence, :canMakeTreasureVisible, :howManyVisibleTreasures, :dieIfNoTreasures, :haveStolen
  protected :canYouGiveMeATreasure, :giveMeATreasure, :getCombatLevel, :getName,:getLevels,  :getPendingBadConsequence
  end

end