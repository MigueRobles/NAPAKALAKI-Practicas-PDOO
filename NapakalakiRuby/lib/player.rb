# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame

  require_relative "treasure"
  require_relative "bad_consequence"
  require_relative "treasure_kind.rb"
  require_relative "treasure"

  class Player
    MAXLEVEL = 10



    def initialize(name)

      @name = name
      @level = 1
      @dead = true
      @CanISteal = true
      @hiddenTreasures = Array.new()
      @visibleTreasures = Array.new()
      @badConsequence = BadConsequence.new()
    end

    def getName()
      @name
    end

    def bringtoLife()
      @dead = false
    end

    def isDead()
      @dead
    end

    def getCombatlevel()
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

    def setPendingBadConsequence(b)#Duda
      @badConsequence = b
    end

    def dieIfNoTreasures()
      @dead = true
    end

    def validState()

      return true if (@badConsequence.isEmpty() == true && @hiddenTreasures < 5 && @visibleTreasures < 5)

      return false
    end

    def howManyVisibleTreasures(tKind)
      i = 0
      @visibleTreasures.each do |t|
        if (t == tKind)
          i += 1
        end
      end 
    end

    def getLevels()s
      @level
    end

    def canISteal()
      @canISteal
    end

    def haveStolen()
      @canISteal = false
    end

    def canYouGiveMeATreasure()
      return true if (@HiddenTreasures.size() > 0)
      return false
    end

    def getHiddenTreasures()
      @hiddenTreasures
    end

    def getVisibleTreasures()
      @visibleTreasures
    end

    def applyPrize(m)
      @level += m.levels

    end

    def applyBadConsequence(m)

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

    def initTreasures()

    end

    def stealTreasure()

    end

    def giveMeATreasure()

    end

    def discardAllTreasures()

    end

    def setEnemy(enemy)

    end


end

end