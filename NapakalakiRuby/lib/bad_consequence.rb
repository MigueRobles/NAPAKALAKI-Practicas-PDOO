# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence

  attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death, :specificHiddenTreasures, :specificVisibleTreasures
  
  def initialize
    
  end
  
  def to_s
    if (death)
      "Estás muerto, pierdes todos tus objetos y vuelves al nivel 1\n"
    end
    
    else if(@nVisibleTreasures > 0 || @nHiddenTreasures > 0)
        text = @text + "\nDebes descartarte de:\n"
        if (@nVisibleTreasures > 0)
          if (@nVisibleTreasures != MAX_VALUE) # Tal vez debamos definir esta constante en algún lado jeje 
            text += @nVisibleTreasures + " tesoros visibles:\n"
            #Falta indicar los objetos específicos que se pierden y el resto del to_s
          end
          
        end
    end
  end
  
  
end
