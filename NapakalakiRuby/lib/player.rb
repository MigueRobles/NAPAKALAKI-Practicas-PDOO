# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame

  require_relative "treasure"
  require_relative "bad_consequence"
  require_relative "treasure_kind.rb"
  require_relative "treasure"

  class Player
    @@MAXLEVEL = 10

    def initialize(name)

      @name = name
      @level = 1
      @dead = true
      @canISteal = true
      @hiddenTreasures = Array.new()
      @visibleTreasures = Array.new()
      @pendingBadConsequence = nil
      @enemy = nil
    end

    def getName
      @name
    end

    def bringtoLife
      @dead = false
    end

    def getCombatlevel
      clevel = @level
      @VisibleTreasures.each { |trea| clevel += trea.getBonus }
      return clevel
    end

    def incrementLevels(i)#ver si nivel esta entre 0 y 10 y que no se quede negativo
      @level += i    
    end

    def decrementLevels(i)
      @level -= i
    end

    def setPendingBadConsequence(b)
      @pendingBadConsequence = b
    end
    
    def applyPrize(m)
      @level += m.levels
      m.treasure.each do |tesoro| 
        @hiddenTreasures << tesoro
      end
    end

    def applyBadConsequence(b)
      if(b.death == true)
        @levels = 1
        @hiddenTreasures.clear()
        @visibleTreasures.clear()
        @pendingBadConsequence.clear() # Para comprobar el estado válido vemos si no tiene ningún mal rollo por cumplir
      end
      
    else 
      @levels -= b.levels
      
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
      return true if (@pendingBadConsequence.isEmpty() == true && @hiddenTreasures.length < 5)
      
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
      return true if (@HiddenTreasures.size() > 0)
      return false
    end

    def haveStolen
      @canISteal = false
    end

    def canMakeTreasureVisible(t)

    end

    def combat(m)

    end

    def makeTreasureVisible(t)

    end

    def discardVisibleTreasure(t)

    end

    def discardHiddenTreasure(t)

    end

    def initTreasures

    end

    def stealTreasure

    end

    def giveMeATreasure

    end

    def discardAllTreasures

    end
    
  private :bringToLife, :getCombatLevel, :incrementLevels, :decrementLevels, :setPendingBadConsequence, :applyPrize, :applyBadConsequence, :canMakeTreasureVisible, :howManyVisibleTreasures, :dieIfNoTreasures, :giveMeATreasure, :canYouGiveMeATreasure, :haveStolen

    
  end

end