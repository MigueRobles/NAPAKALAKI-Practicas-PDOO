# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
  require_relative "treasure"
  require_relative "bad_consequence"
  require_relative "treasure_kind.rb"

module NapakalakiGame


  class Player
    @@MAXLEVEL = 10

    def initialize(name)

      @name = name
      @level = 1
      @dead = true
      @canISteal = true
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
      @pendingBadConsequence = nil
      @enemy = nil
    end

    def getName
      @name
    end

    def bringToLife
      @dead = false
    end

    def getCombatLevel
      clevel = @level
      @VisibleTreasures.each { |trea| clevel += trea.getBonus }
      return clevel
    end

    def incrementLevels(i)
      if ((@level+i)>10)
        @level = 10
      else
        @level += i
      end    
    end

    def decrementLevels(i)
      if (i>@level)
        @level = 1
      else
        @level -= i
      end
    end

    def setPendingBadConsequence(b)
      @pendingBadConsequence = b
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

    def applyBadConsequence(b)
      badConsequence = m.getBadconsequence
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
      if @VisibleTreasures.empty? and @HiddenTreasures.empty?
      @dead = true
      end
    end
    
    def isDead
      @dead
    end    
    
    def getHiddenTreasures
      @hiddenTreasures
    end

    def getVisibleTreasures
      @visibleTreasures
    end

    def validState
      return true if (@pendingBadConsequence == nil)
      return true if (@pendingBadConsequence.isEmpty == true && @hiddenTreasures.length < 5)
      
      return false
    end

    def getLevels
      @level
    end
    
    def setEnemy(enemy)
      @enemy = enemy
    end

    def canISteal
      @canISteal
    end
    
    def canYouGiveMeATreasure
      return true if (@hiddenTreasures.size() > 0)
      return false
    end

    def haveStolen
      @canISteal = false
    end

   def canMakeTreasureVisible(t)
      
      if (t.getType == TreasureKind::ONEHAND)         # Para una mano
        if (treasureInUse(TreasureKind::BOTHHANDS))   # Si tenemos equipada una de dos manos
          return false
        else                                          # Si no tenemos de dos manos, ¿Cuántas de 1 mano?
          una_mano = 0
          @visibleTreasures.each do |i|
            if (TreasureKind::ONEHAND == i.getType)
              una_mano += 1
            end
          end
          if (una_mano >= 2)                          # Si tenemos 2 o más -> No
            return false
          end
        end
        
      else
        if (t.getType == TreasureKind::BOTHHANDS)     # Para dos manos
          if (treasureInUse(TreasureKind::BOTHHANDS) || treasureInUse(TreasureKind::ONEHAND))
            return false
          end
        else
          if (treasureInUse(t.getType))               # Resto del tipo de tesoros
            return false
          end
        end
      end
      return true
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
      monsterLevel = m.getCombatLevel
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
        if (@level >= 10)
          combatResult = CombatResult::WINGAME
        else
          combatResult = CombatResult::WIN
        end
      else
        applyBadConsequence(m)
        combatResult = CombatResult::LOSE
      end
      return combatResult
    end
    
   def makeTreasureVisible(t)
      canI = canMakeTreasureVisible(t)
      if (canI)
        @visibleTreasures << t
        @hiddenTreasures.delete_at(@hiddenTreasures.index(t)||@hiddenTreasures.length)
      end
    end

        def discardVisibleTreasure(t)
      @visibleTreasures.delete_at(@visibleTreasures.index(t)||@hiddenTreasures.length)
      if (@pendingBadConsequence != nil && @pendingBadConsequence.isEmpty() == false)
        @pendingBadConsequence.substractVisibleTreasure(t)
      end
      
      dieIfNoTreasures()
    end

    def discardHiddenTreasure(t)
      @hiddenTreasures.delete_at(@hiddenTreasures.index(t) || @hiddenTreasures.length)
      if (@pendingBadConsequence != nil)
        if(@pendingBadConsequence.isEmpty() == false)
          @pendingBadConsequence.substractHiddenTreasure(t)
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
      return @hiddenTreasures[indice]
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
    
  private :bringToLife, :getCombatLevel, :incrementLevels, :decrementLevels, :setPendingBadConsequence, :applyPrize, :applyBadConsequence, :canMakeTreasureVisible, :howManyVisibleTreasures, :dieIfNoTreasures, :giveMeATreasure, :canYouGiveMeATreasure, :haveStolen

    
  end

end