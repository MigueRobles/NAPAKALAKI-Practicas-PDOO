#encoding: utf-8

# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

require_relative "prize"
require_relative "card_dealer"
require_relative "bad_consequence"
require_relative "treasure_kind"
require_relative "monster"
require_relative "dice"
require_relative "player"
require_relative "treasure"
  
module NapakalakiGame

  class Napakalaki  
=begin
    premio = Prize.new(Array.new, 15)
      puts premio.to_s
      puts
    bc = BadConsequence.newLevelNumberOfTreasures("Lose the Game", 23, 2, 3)
      puts bc.to_s
      puts

    monstruo_de_prueba = Monster.new("Chino", 10, bc, premio)  
      puts monstruo_de_prueba.to_s
      puts
    bac = BadConsequence.newLevelSpecificTreasures("Lose the Gamex2",25, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      puts bac.to_s
      puts
    muere = BadConsequence.newDeath ("Sweet Home Halacama")
      puts muere.to_s
      puts

    def self.Lvl10Up
      puts "Lvl10Up >10"
      cadena = Array.new
      @@monsters.each do |monst|
        cadena << monst if (monst.getCombatLevel > 10)
        end
      cadena
    end

    def self.LoseJustLvl
      puts "LoseJustLvl"
      cadena = Array.new
      @@monsters.each do |monst|
        if(monst.getBadConsequence.getLevels != 0 && monst.getBadConsequence.getDeath == false && monst.getBadConsequence.getNVisibleTreasures == 0 && monst.getBadConsequence.getNHiddenTreasures == 0 && monst.getBadConsequence.getSpecificHiddenTreasures == Array.new && monst.getBadConsequence.getSpecificVisibleTreasures == Array.new )
          cadena << monst
        end     
      end
      cadena
    end

    def self.Up23Lvl
      puts "Up23Lvl"
      cadena = Array.new
      @@monsters.each do |monst|
        cadena << monst if (monst.getLevelsGained > 1 )
      end
      cadena
    end

    def self.LoseObject(obj)
      puts "LoseObject"
      cadena = Array.new
         @@monsters.each do |monst| 
          monst.getBadConsequence.getSpecificVisibleTreasures.each do |test|
            if (test == obj)
              cadena << monst
            end
          end      
            monst.getBadConsequence.getSpecificHiddenTreasures.each do |test|
              cadena << monst if (test == obj)
            end
          end
      cadena
    end


    # Definimos array para los monstruos
    @@monsters = Array.new

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta.", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @@monsters << Monster.new("3 Byakhees de bonanza", 8, bc, prize)

    prize = Prize.new(1, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, [TreasureKind::HELMET], [])
    @@monsters << Monster.new("Tenochtitlan", 2, bc, prize)

    prize = Prize.new(1, 1)
    bc = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, [TreasureKind::SHOES], [])
    @@monsters << Monster.new("El sopor de Dunwich", 2, bc, prize)

    prize = Prize.new(4, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    @@monsters << Monster.new("Demonios de Magaluf", 2, bc, prize)

    prize = Prize.new(3, 1)
    bc = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles.", 0, 5, 0)
    @@monsters << Monster.new("El gorron en el umbral", 13, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible.", 0, [TreasureKind::ARMOR], [])
    @@monsters << Monster.new("H.P. Munchcraft", 6, bc, prize)

    prize = Prize.new(1, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, [TreasureKind::ARMOR], [])
    @@monsters << Monster.new("Necrofago", 13, bc, prize)

    prize = Prize.new(3, 2)
    bc = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0)
    @@monsters << Monster.new("El rey de rosado", 11, bc, prize)

    prize = Prize.new(1, 1)
    bc = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0)
    @@monsters << Monster.new("Flecher", 2, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newDeath("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estas muerto.")
    @@monsters << Monster.new("Los hondos", 8, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2)
    @@monsters << Monster.new("Semillas Cthulhu", 4, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible.", 0, [TreasureKind::ONEHAND], [])
    @@monsters << Monster.new("Dameargo", 1, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0)
    @@monsters << Monster.new("Pollipolipo volante", 3, bc, prize)

    prize = Prize.new(3, 1)
    bc = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estas muerto.")
    @@monsters << Monster.new("Yskhtihyssg-Goth", 14, bc, prize)

    prize = Prize.new(3, 1)
    bc = BadConsequence.newDeath("La familia te atrapa. Estas muerto.")
    @@monsters << Monster.new("Familia feliz", 1, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, [TreasureKind::BOTHHANDS], [])
    @@monsters << Monster.new("Roboggoth", 8, bc, prize)

    prize = Prize.new(1, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible.", 0, [TreasureKind::HELMET], [])
    @@monsters << Monster.new("El espia sordo", 5, bc, prize)

    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0)
    @@monsters << Monster.new("Tongue", 19, bc, prize)
    #REVISAR EL ULTIMO MONSTRUO
    prize = Prize.new(2, 1)
    bc = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, [TreasureKind::ONEHAND,TreasureKind::ONEHAND,TreasureKind::BOTHHANDS], [])
    @@monsters << Monster.new("Bicefalo", 21, bc, prize)


    # Mostrar los monstruos
    #@@monsters.each do |showmonster|    
    #showmonster.to_s
    #end
      # Comprobar metodos
    puts "*****Comprobamos Métodos*****"


    prueba = Lvl10Up()
    puts
    prueba.each do |mon|
      puts mon.to_s
    end

    prueba = LoseJustLvl()
    puts
    prueba.each do |mon|
      puts mon.to_s
    end

    prueba = Up23Lvl()
    puts
    prueba.each do |mon|
      puts mon.to_s
    end

    prueba = LoseObject(TreasureKind::HELMET)
    prueba.each do |j|
      puts j.to_s
    end

    prueba = LoseObject(TreasureKind::SHOES)
    prueba.each do |j|
      puts j.to_s
    end

    prueba = LoseObject(TreasureKind::ONEHAND)
    prueba.each do |j|
      puts j.to_s
    end

    prueba = LoseObject(TreasureKind::BOTHHANDS)
    prueba.each do |j|
      puts j.to_s
    end

    prueba = LoseObject(TreasureKind::ARMOR)
    prueba.each do |j|
      puts j.to_s
    end
=end   
    
  
  end
  
  premio = Prize.new(5, 15)
    puts premio.to_s
    puts
  bc = BadConsequence.newLevelNumberOfTreasures("Lose the Game", 23, 0, 0)
    puts bc.to_s
    puts bc.isEmpty
    puts

  bc = BadConsequence.newLevelNumberOfTreasures("Amapola", 23, 2, 3)
    puts bc.to_s
    puts bc.isEmpty
    puts
    
  d = Dice.instance
    puts d.nextNumber
    puts
    
  m = Monster.new("Yskhtihyssg-Goth", 14, bc, premio)
    puts m.getLevelsGained
    puts m.getTreasuresGained
    puts 
    
  t = Treasure.new("¡Sí mi amo!", 4, [TreasureKind::HELMET])
    puts t.getName
    puts t.getBonus
    puts t.getType
    puts
    
  p1 = Player.new("Urqui")
  p2 = Player.new("Pedos")

    puts p1.isDead
    puts p1.getName
    puts p1.getLevels
    puts p1.setEnemy(p2)
    puts p1.canISteal
    puts p1.validState
    
  c = CardDealer.instance
=begin  # Métodos que solo funcionarán si los metodos privados de cardDealer se hacen públicos
    c.initTreasureCardDeck
    c.initMonsterCardDeck
    c.shuffleMonsters
=end
  c.giveTreasureBack(t)
  c.giveMonsterBack(m)

  
end
