
# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
class Prize
  attr_accessor :treasures, :levels # Alternativamente se pueden usar métodos set/get 
 
  def initialize(treasures, levels)
    @treasures = treasures
    @levels = levels
  end
  
  def to_s
    "Tesoros ganados: #{@treasures} \nNiveles ganados: #{@levels}" 
  end
  
end



