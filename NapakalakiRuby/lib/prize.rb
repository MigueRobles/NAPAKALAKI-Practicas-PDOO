
# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada
class Prize
  #Alternativamente a los set/get se puede usar "attr_accessor :treasures,:levels"
  
  def initialize(treasures, levels)
    @treasures = treasures
    @levels = levels
  end
  
  def getTreasures
    @treasures
  end
  
end



