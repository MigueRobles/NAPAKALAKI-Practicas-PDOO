# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

  require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

module NapakalakiGame
  class BadConsequence
    
    @@MAXTREASURES = 10
    private_class_method :new
  
    def initialize(aText, someLevels)
      @text = aText
      @levels = someLevels
    end 
    
    def self.MAXTREASURES
      @@MAXTREASURES
    end
    
    def getLevels
      @levels
    end
    def to_s
      "#{@text}\nPierdes #{@levels} niveles.\n"
    end 
  end
end