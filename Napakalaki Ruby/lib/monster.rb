# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame
  class Monster

    def initialize(n, l, b, p, cl)
      @name = n
      @combatLevel = l
      @badConsequence = b
      @prize = p
      @levelChangeAgainstCultistPlayer = cl
    end   
    
    def getName
      @name
    end

    def getCombatLevel
      @combatLevel
    end
    
    def getBadConsequence         
      @badConsequence
    end
    
    def getTreasuresGained          # Número de treasures que se obtienen al ganar
      @prize.getTreasures.size()
    end

    def getLevelsGained             # Levels que se obtienen al ganar
      @prize.getLevels
    end
    
    def getLevelsGained         
      @prize.getLevels
    end
    
    def getTreasuresGained         
      @prize.getTreasures
    end
    
    def getCombatLevelAgainstCultistPlayer
      getCombatLevel + @levelChangeAgainstCultistPlayer
    end
    
    def to_s
      "Name: #{@name} \nCombatLevel: #{@combatLevel} (#{getCombatLevelAgainstCultistPlayer} si eres sectario) \nPrize: #{@prize} \nBadConsequence: #{@badConsequence} \n\n"
    end

  end
end