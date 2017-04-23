# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

module NapakalakiGame
  class Prize

    def initialize(treasures, levels)
      @treasures = treasures
      @levels = levels
    end
    
    def getTreasures
      @treasures
    end
    
    def getLevels
      @levels
    end

    def to_s
      "Tesoros ganados: #{@treasures} \nNiveles ganados: #{@levels}" 
    end

  end


end