# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Monster
  
  attr_accessor :name, :combatLevel, :badconsequence, :prize
  def initialize
    
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
  
end
