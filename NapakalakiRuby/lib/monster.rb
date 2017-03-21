# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame
  class Monster

    attr_accessor :name, :combatLevel, :badconsequence, :prize

    def initialize(name, combatLevel,badconsequence,prize)
      @name = name
      @combatLevel = combatLevel
      @badconsequence = badconsequence
      @prize = prize
    end

    def getTreasures          # Treasures que se obtienen al ganar
      @prize.treasures
    end

    def getLevels             # Levels que se obtienen al ganar
      @prize.levels
    end

    def getKill               # Indica si el monstruo tiene la capacidad de matar
      @badconsequence.death
    end

    def to_s
      "Name: #{@name} \nCombatLevel: #{@combatLevel} \nPrize: #{@prize} \nBadConsequence: #{@badconsequence} \n\n"
    end

  end
end