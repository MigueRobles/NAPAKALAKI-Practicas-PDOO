# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

require_relative "prize.rb"
require_relative "bad_consequence.rb"
require_relative "treasure_kind.rb"
require_relative "monster.rb"
#encoding: utf-8

class Napakalaki
  # Definimos array para los monstruos
  @@monsters = Array.new
  
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta.", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  @@monsters << Monster.new("3 Byakhees de bonanza", 8, bc, prize)
  
  prize = Prize.new(1, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, [TreasureKind::HELMET], nil)
  @@monsters << Monster.new("Tenochtitlan", 2, bc, prize)
  
  prize = Prize.new(1, 1)
  bc = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, [TreasureKind::SHOES], nil)
  @@monsters << Monster.new("El sopor de Dunwich", 2, bc, prize)
  
  prize = Prize.new(4, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  @@monsters << Monster.new("Demonios de Magaluf", 2, bc, prize)
  
  prize = Prize.new(3, 1)
  bc = BadConsequence.newLevelNumberofTreasures("Pierdes todos tus tesoros visibles.", 0, 5, 0)
  @@monsters << Monster.new("El gorrón en el umbral", 13, bc, prize)
  
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible.", 0, [TreasureKind::ARMOR], nil)
  @@monsters << Monster.new("H.P. Munchcraft", 6, bc, prize)
  
  prize = Prize.new(1, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, [TreasureKind::ARMOR], nil)
  @@monsters << Monster.new("Necrófago", 13, bc, prize)
  
  prize = Prize.new(3, 2)
  bc = BadConsequence.newLevelNumberofTreasures("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0)
  @@monsters << Monster.new("El rey de rosado", 11, bc, prize)
  
  prize = Prize.new(1, 1)
  bc = BadConsequence.newLevelNumberofTreasures("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0)
  @@monsters << Monster.new("Flecher", 2, bc, prize)

  prize = Prize.new(2, 1)
  bc = BadConsequence.newDeath("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto.")
  @@monsters << Monster.new("Los hondos", 8, bc, prize)
  
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelNumberofTreasures("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)
  @@monsters << Monster.new("Semillas Cthulhu", 4, bc, prize)

  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible.", 0, [TreasureKind::ONEHAND], nil)
  @@monsters << Monster.new("Dameargo", 1, bc, prize)
  
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelNumberofTreasures("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0)
  @@monsters << Monster.new("Pollipólipo volante", 3, bc, prize)
  
  prize = Prize.new(3, 1)
  bc = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto.")
  @@monsters << Monster.new("Yskhtihyssg-Goth", 14, bc, prize)
  
  prize = Prize.new(3, 1)
  bc = BadConsequence.newDeath("La familia te atrapa. Estás muerto.")
  @@monsters << Monster.new("Familia feliz", 1, bc, prize)
  
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, [TreasureKind::BOTHHANDS], nil)
  @@monsters << Monster.new("Roboggoth", 8, bc, prize)
  
  prize = Prize.new(1, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible.", 0, [TreasureKind::HELMET], nil)
  @@monsters << Monster.new("El espía sordo", 5, bc, prize)
  
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelNumberofTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0)
  @@monsters << Monster.new("Tongue", 19, bc, prize)
  #REVISAR EL ULTIMO MONSTRUO
  prize = Prize.new(2, 1)
  bc = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, [TreasureKind::ONEHAND,ONEHAND,BOTHHANDS], nil)
  @@monsters << Monster.new("Bicéfalo", 21, bc, prize)
  
  
  # Mostrar los monstruos
  monstruos.each do |show_monster|
    
    
  end
  
end
