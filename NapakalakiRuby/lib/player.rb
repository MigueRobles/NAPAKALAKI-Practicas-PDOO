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
      @CanISteal = true
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

    def isDead
      @dead
    end

    def getCombatlevel
      clevel = @level
      @specificVisibleTreasures.each { |trea| clevel += trea.getBonus }
      return clevel
    end

    def incrementLevels(i)
      @level += i    
    end

    def decrementLevels(i)
      @level -= i
    end

    def setPendingBadConsequence(b)
      @pendingBadConsequence = b
    end

    def dieIfNoTreasures
      if @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty?
      @dead = true
      end
    end

    def validState
      return true if (@pendingBadConsequence.isEmpty() == true && @hiddenTreasures < 5)
      
      return false
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

    def getLevels
      @level
    end
    
    def setEnemy(en)
      @enemy = en
    end

    def canISteal
      @canISteal
    end

    def haveStolen
      @canISteal = false
    end

    def canYouGiveMeATreasure
      return true if (@HiddenTreasures.size() > 0)
      return false
    end

    def getHiddenTreasures
      @hiddenTreasures
    end

    def getVisibleTreasures
      @visibleTreasures
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

    def setEnemy(enemy)

    end


end

end