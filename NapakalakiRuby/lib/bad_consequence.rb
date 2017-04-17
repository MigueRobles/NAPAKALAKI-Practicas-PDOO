# By: Miguel Robles Urquiza
#     Jesús Sánchez de Lechina Tejada

  require_relative "monster"
  require_relative "prize"
  require_relative "treasure_kind"

module NapakalakiGame
  class BadConsequence
    
    @@MAXTREASURES = 10
    private_class_method :new


    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)

      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @death = death
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures
    end 


  def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new(), Array.new(), false)
    end

    def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
    end

    def self.newDeath (aText, death)
      new(aText, Player.MAXLEVEL, @@MAXTREASURES, @@MAXTREASURES, Array.new(), Array.new(), death)
    end

    def isEmpty
      if(@nHiddenTreasures == 0 and @nVisibleTreasures == 0 and @specificVisibleTreasures == Array.new and @specificHiddenTreasures == Array.new())
        true
      else
        false
      end
      
    end
    
    def getLevels
      @levels      
    end
    
    def to_s
      if (@death == true)
        "Text: #{@text} \nDeath: #{@death}"
      else
        if (@specificHiddenTreasures == Array.new() && @specificVisibleTreasures == Array.new())
          "Text: #{@text} \nLevels: #{@levels} \nVisibleTreasures: #{@nVisibleTreasures} \nHiddenTreasures: #{@nHiddenTreasures}"
        else
          "Text: #{@text} \nSpecificVisibleTreasures: #{@specificVisibleTreasures} \nSpecificHiddenTreasures: #{@specificHiddenTreasures}"
        end
      end
    end
    
    def getNVisibleTreasures
      @nVisibleTreasures
    end
    
    def getNHiddenTreasures
      @nHiddenTreasures
    end
    
    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end
    
    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end
    
    def getDeath
      @death
    end

    def substractVisibleTreasure(t)
      @specificVisibleTreasures.remove(t.getType()) if (@specificVisibleTreasures.contains(t.getType))
    end
    
    def substractHiddenTreasure(t)
      @specificHiddenTreasures.remove(t.getType()) if (@specificHiddenTreasures.contains(t.getType))
     
    end        
   
    def adjustToFitTreasureLists(v,h)
        if(@nHiddenTreasures > 0 || @nVisibleTreasures > 0) 
            

            if(@nHiddenTreasures > h.size())
                n_ocultos = h.size();
            else
                n_ocultos = @nHiddenTreasures;
            end
            if(@nVisibleTreasures > v.size())
                n_visibles = v.size();
            else
                n_visibles = @nVisibleTreasures;
            end
            final_bc =BadConsequence.newLevelNumberOfTreasures(@text, @levels, n_visibles, n_ocultos)
            
            return final_bc   
        
        else 
            @specificVisibleTreasures.each do |visible|    
              if(v.include?(visible))
                      @v_visible.push(visible);
              end
            end
             @specificVisibleTreasures.each do |oculto|    
              if(h.include?(oculto))
                      @v_oculto.push(oculto);
              end
            end
            
            final_bc = BadConsequence.newLevelSpecificTreasures(@text, @levels, @v_visible, @v_oculto);
        end
            return final_bc;    
        
    end

    
  end
end