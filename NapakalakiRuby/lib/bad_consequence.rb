# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  MAX_VALUE=100
  private_class_method :new

  attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death, :specificHiddenTreasures, :specificVisibleTreasures
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nhiddenTreasures = someHiddenTreasures
    @death = death
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddeTreasures = someSpecificHiddenTreasures
  end 
    
  
def self.newLevelNumberofTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new, Array.new, false)
  end

  def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
  end

  def self.newDeath (aText)
    new(aText, 0, 0, 0, Array.new, Array.new, true)
  end
  
  def to_s
    if (death)
      "Estas muerto, pierdes todos tus objetos y vuelves al nivel 1\n"
    end
      
    if(@nVisibleTreasures.to_i  > 0 || @nHiddenTreasures.to_i  > 0)
        text = @text + "\nDebes descartarte de:\n"
          
        if (@nVisibleTreasures.to_i  > 0)
          
          if (@nVisibleTreasures.to_i  != MAX_VALUE) # Tal vez debamos definir esta constante en algún lado jeje 
          text += "#{@nVisibleTreasures} tesoros visibles:\n #{@specificVisibleTreasures}\n"  
          else
            text += "Todos los tesoros visibles\n"
          end
        end  
        
      if (@nHiddenTreasures.to_i  > 0)
        if (@nHiddenTreasures.to_i  != MAX_VALUE)
          text += "#{@nHiddenTreasures} tesoros ocultos:\n #{@specificHiddenTreasures}"
        else
          text += "Todos los tesoros visibles\n"
        end
      end
    end
  end
end