# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
 require "singleton"

module NapakalakiGame

  class Dice
     
    include Singleton

    def nextNumber
        return 1 + rand(6)
    end
    
  end
end