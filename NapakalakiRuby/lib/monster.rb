# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

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
    "Monster: #{@name} \nCombat level: #{@combatLevel} \nPrize: #{@prize.to_s} \nBad consequence: #{@badconsequence.to_s} "
  end
  
end
