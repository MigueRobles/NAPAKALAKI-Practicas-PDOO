# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame
  require "singleton"

  class Dice
    
    def inicialize
      
    end
    
    include Singleton

    def nextNumber
        return 1 + rand(6)
    end
    
  end
end