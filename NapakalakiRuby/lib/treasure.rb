# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

#encoding: utf-8

require_relative "treasure_kind"


class Treasure
  
  def initialize (n, bonus, t)
     @name = n
     @bonus = bonus
     @type = t
    end
    def getName()
      @name
  
    end
        
    def getBonus
      @bonus
    end
    
    def getType
      @type
    end
    
    def to_s
      "Treasure: #{@name} Type: #{@type} Bonus:{@bonus}\n" 
    end
    
end
