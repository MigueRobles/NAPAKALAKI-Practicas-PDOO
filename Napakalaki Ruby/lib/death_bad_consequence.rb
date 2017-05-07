# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'numeric_bad_consequence'
require_relative 'player'

module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence
    public_class_method :new

    def initialize(aText, death)
        super(aText, Player.MAXLEVEL, BadConsequence.MAXTREASURES, BadConsequence.MAXTREASURES)
        @death = death
    end

    def to_s
      "#{@text}. Pierdes todos los tesoros y vuelves al nivel uno.\n"
    end

    def getDeath
      @death
    end
  end
end