package org.wiselot.ArithTest.ExtMath.Objects;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BandFraction extends Fraction{

    private int suffix;

    public BandFraction(int Molecule, int Denominator , int suffix) throws InvalidFractionException {
        super(Molecule, Denominator);
        this.suffix = suffix;
    }

    public Fraction toFraction(@NotNull BandFraction bandFraction) throws InvalidFractionException {
        return(new Fraction(
                bandFraction.suffix * bandFraction.Denominator + bandFraction.Molecule,
                bandFraction.Denominator
        ));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandFraction that = (BandFraction) o;
        Fraction a = null;
        Fraction b = null;
        try {
            a = that.toFraction(that);
            b = this.toFraction(this);
        } catch (InvalidFractionException e) {
            e.printStackTrace();
        }
        return a.equals(b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), suffix);
    }
}
