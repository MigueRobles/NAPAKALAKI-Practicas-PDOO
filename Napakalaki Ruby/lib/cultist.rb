# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame

  class Cultist

    def initialize(name, gainedLevels)
      @name = name
      @gainedLevels = gainedLevels

    end
    
    def to_s
      return "#{@name} (CombatLevel +#{@gainedLevels}) "
    end

    def getGainedLevels
      @gainedLevels
    end
  end
  
end
