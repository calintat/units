package com.calintat.units.utils

import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import com.calintat.units.R
import com.calintat.units.R.string.*

object Converter {

    fun get(@IdRes id: Int) = idMap[id] ?: throw NoSuchElementException("Identifier not found")

    //----------------------------------------------------------------------------------------------

    class Unit(@StringRes val name: Int, @StringRes val symbol: Int, val a: Double = 1.0, val b: Double = 0.0, val n: Double = 1.0) {

        fun selfToBase(x: Double) = a * Math.pow(x, n) + b

        fun baseToSelf(y: Double) = Math.pow((y - b) / a, 1/n)
    }

    class Quantity(@IdRes val id: Int, @StringRes val name: Int, @ColorRes val color: Int, @ColorRes val colorDark: Int, @DrawableRes val shortcutIcon: Int, val units: Array<Unit>, val rank: Int)

    //----------------------------------------------------------------------------------------------

    private val METRE = Unit(metre, symbol_metre)

    private val KILOMETRE = Unit(kilometre, symbol_kilometre, 1000.0)

    private val MILE = Unit(mile, symbol_mile, 1609.344)

    private val YARD = Unit(yard, symbol_yard, 0.9144)

    private val FOOT = Unit(foot, symbol_foot, 0.3048)

    private val INCH = Unit(inch, symbol_inch, 0.0254)

    private val CENTIMETRE = Unit(centimetre, symbol_centimetre, 0.01)

    private val MILLIMETRE = Unit(millimetre, symbol_millimetre, 1e-3)

    private val MICROMETRE = Unit(micrometre, symbol_micrometre, 1e-6)

    private val ANGSTROM = Unit(angstrom, symbol_angstrom, 1e-10)

    private val AU = Unit(astronomical_unit, symbol_astronomical_unit, 149597870700.0)

    private val LIGHT_YEAR = Unit(light_year, symbol_light_year, 9.4607304725808e15)

    private val PARSEC = Unit(parsec, symbol_parsec, 3.085677581e16)

    private val NANOMETRE = Unit(nanometre, symbol_nanometre, 1e-9)

    private val PICOMETRE = Unit(picometre, symbol_picometre, 1e-12)

    private val FERMI = Unit(fermi, symbol_fermi, 1e-15)

    private val FATHOM = Unit(fathom, symbol_fathom, 1.8288)

    private val FURLONG = Unit(furlong, symbol_furlong, 201.168)

    private val NAUTICAL_MILE = Unit(nautical_mile, symbol_nautical_mile, 1852.0)

    //----------------------------------------------------------------------------------------------

    private val SQUARE_METRE = Unit(square_metre, symbol_square_metre)

    private val SQUARE_KILOMETRE = Unit(square_kilometre, symbol_square_kilometre, 1e6)

    private val ARE = Unit(are, symbol_are, 100.0)

    private val HECTARE = Unit(hectare, symbol_hectare, 10000.0)

    private val ACRE = Unit(acre, symbol_acre, 4046.8564224)

    private val CUERDA = Unit(cuerda, symbol_cuerda, 3930.395625)

    private val SQUARE_YARD = Unit(square_yard, symbol_square_yard, 0.83612736)

    private val SQUARE_FOOT = Unit(square_foot, symbol_square_foot, 9.290304e-2)

    private val SQUARE_INCH = Unit(square_inch, symbol_square_inch, 6.4516e-4)

    //----------------------------------------------------------------------------------------------

    private val CUBIC_METRE = Unit(cubic_metre, symbol_cubic_metre)

    private val LITRE = Unit(litre, symbol_litre, 0.001)

    private val MILLILITRE = Unit(millilitre, symbol_millilitre, 1e-6)

    private val CUBIC_FOOT = Unit(cubic_foot, symbol_cubic_foot, 0.028316846592)

    private val CUBIC_INCH = Unit(cubic_inch, symbol_cubic_inch, 16.387064e-6)

    private val IMPERIAL_GALLON = Unit(imperial_gallon, symbol_imperial_gallon, 4.54609e-3)

    private val US_GALLON = Unit(us_gallon, symbol_us_gallon, 3.785411784e-3)

    private val IMPERIAL_QUART = Unit(imperial_quart, symbol_imperial_quart, 1.1365225e-3)

    private val US_QUART = Unit(us_quart, symbol_us_quart, 946.352946e-6)

    private val IMPERIAL_PINT = Unit(imperial_pint, symbol_imperial_pint, 568.26125e-6)

    private val US_PINT = Unit(us_pint, symbol_us_pint, 473.176473e-6)

    private val IMPERIAL_FLUID_OUNCE = Unit(imperial_fluid_ounce, symbol_imperial_fluid_ounce, 28.4130625e-6)

    private val US_FLUID_OUNCE = Unit(us_fluid_ounce, symbol_us_fluid_ounce, 29.5735295625e-6)

    private val IMPERIAL_TABLESPOON = Unit(imperial_tablespoon, symbol_imperial_tablespoon, 17.7581640625e-6)

    private val US_TABLESPOON = Unit(us_tablespoon, symbol_us_tablespoon, 14.78676478125e-6)

    private val IMPERIAL_TEASPOON = Unit(imperial_teaspoon, symbol_imperial_teaspoon, 5.9193880208333e-6)

    private val US_TEASPOON = Unit(us_teaspoon, symbol_us_teaspoon, 4.92892159375e-6)

    //----------------------------------------------------------------------------------------------

    private val KILOGRAM = Unit(kilogram, symbol_kilogram)

    private val STONE = Unit(stone, symbol_stone, 6.35029318)

    private val POUND = Unit(pound, symbol_pound, 0.45359237)

    private val OUNCE = Unit(ounce, symbol_ounce, 28.349523125e-3)

    private val IMPERIAL_TON = Unit(imperial_ton, symbol_imperial_ton, 1016.0469088)

    private val US_TON = Unit(us_ton, symbol_us_ton, 907.18474)

    private val TONNE = Unit(tonne, symbol_tonne, 1000.0)

    private val GRAM = Unit(gram, symbol_gram, 0.001)

    private val MILLIGRAM = Unit(milligram, symbol_milligram, 1e-6)

    private val MICROGRAM = Unit(microgram, symbol_microgram, 1e-9)

    private val CARAT = Unit(carat, symbol_carat, 0.0002)

    private val DRAM = Unit(dram, symbol_dram, 1.7718451953125e-3)

    private val GRAIN = Unit(grain, symbol_grain, 64.79891e-6)

    private val ATOMIC_MASS_UNIT = Unit(atomic_mass_unit, symbol_atomic_mass_unit, 1.66053892173e-27)

    private val ELECTRON_REST_MASS = Unit(electron_rest_mass, symbol_electron_rest_mass, 9.1093829140e-31)

    //----------------------------------------------------------------------------------------------

    private val SECOND = Unit(second, symbol_second)

    private val MINUTE = Unit(minute, symbol_minute, 60.0)

    private val HOUR = Unit(hour, symbol_hour, 3.6e3)

    private val DAY = Unit(day, symbol_day, 86.4e3)

    private val WEEK = Unit(week, symbol_week, 604.8e3)

    private val MONTH = Unit(month, symbol_month, 2.592e6)

    private val YEAR = Unit(year, symbol_year, 31.556952e6)

    private val DECADE = Unit(decade, symbol_decade, 315.56952e6)

    private val CENTURY = Unit(century, symbol_century, 3.1556952e9)

    //----------------------------------------------------------------------------------------------

    private val METRE_PER_SECOND = Unit(metre_per_second, symbol_metre_per_second)

    private val MILE_PER_HOUR = Unit(mile_per_hour, symbol_mile_per_hour, 0.44704)

    private val KILOMETRE_PER_HOUR = Unit(kilometre_per_hour, symbol_kilometre_per_hour, 0.277778)

    private val FOOT_PER_SECOND = Unit(foot_per_second, symbol_foot_per_second, 0.30480024384)

    private val KNOT = Unit(knot, symbol_knot, 0.514444855556)

    private val SPEED_OF_LIGHT = Unit(speed_of_light, symbol_speed_of_light, 299792458.0)

    private val SPEED_OF_SOUND = Unit(speed_of_sound, symbol_speed_of_sound, 343.2)

    //----------------------------------------------------------------------------------------------

    private val KELVIN = Unit(kelvin, symbol_kelvin)

    private val CELSIUS = Unit(celsius, symbol_celsius, 1.0, 273.15)

    private val FAHRENHEIT = Unit(fahrenheit, symbol_fahrenheit, 5.0 / 9, 459.67 * 5 / 9)

    //----------------------------------------------------------------------------------------------

    private val KILOMETRE_PER_LITRE = Unit(kilometre_per_litre, symbol_kilometre_per_litre)

    private val MILE_PER_IMPERIAL_GALLON = Unit(mile_per_imperial_gallon, symbol_mile_per_imperial_gallon, 0.354006)

    private val MILE_PER_US_GALLON = Unit(mile_per_us_gallon, symbol_mile_per_us_gallon, 0.425144)

    //----------------------------------------------------------------------------------------------

    private val BIT = Unit(_bit, symbol_bit)

    private val BYTE = Unit(_byte, symbol_byte, 8.0)

    private val KILOBIT = Unit(kilobit, symbol_kilobit, 1000.0)

    private val KIBIBIT = Unit(kibibit, symbol_kibibit, 1024.0)

    private val KILOBYTE = Unit(kilobyte, symbol_kilobyte, 8000.0)

    private val KIBIBYTE = Unit(kibibyte, symbol_kibibyte, 8192.0)

    private val MEGABIT = Unit(megabit, symbol_megabit, 1e6)

    private val MEBIBIT = Unit(mebibit, symbol_mebibit, 1.048576e6)

    private val MEGABYTE = Unit(megabyte, symbol_megabyte, 8e6)

    private val MEBIBYTE = Unit(mebibyte, symbol_mebibyte, 8.38860836)

    private val GIGABIT = Unit(gigabit, symbol_gigabit, 1e9)

    private val GIBIBIT = Unit(gibibit, symbol_gibibit, 1.073741824e9)

    private val GIGABYTE = Unit(gigabyte, symbol_gigabyte, 8e9)

    private val GIBIBYTE = Unit(gibibyte, symbol_gibibyte, 8.589934592e9)

    private val TERABIT = Unit(terabit, symbol_terabit, 1e12)

    private val TEBIBIT = Unit(tebibit, symbol_tebibit, 1.099511627776e12)

    private val TERABYTE = Unit(terabyte, symbol_terabyte, 8e12)

    private val TEBIBYTE = Unit(tebibyte, symbol_tebibyte, 8.796093022208e12)

    private val PETABIT = Unit(petabit, symbol_petabit, 1e15)

    private val PEBIBIT = Unit(pebibit, symbol_pebibit, 1.125899906842624e15)

    private val PETABYTE = Unit(petabyte, symbol_petabyte, 8e15)

    private val PEBIBYTE = Unit(pebibyte, symbol_pebibyte, 9.007199254740992e15)

    //----------------------------------------------------------------------------------------------

    private val KILOBIT_PER_SECOND = Unit(kilobit_per_second, symbol_kilobit_per_second, 1000.0)

    private val KIBIBIT_PER_SECOND = Unit(kibibit_per_second, symbol_kibibit_per_second, 1024.0)

    private val KILOBYTE_PER_SECOND = Unit(kilobyte_per_second, symbol_kilobyte_per_second, 8000.0)

    private val KIBIBYTE_PER_SECOND = Unit(kibibyte_per_second, symbol_kibibyte_per_second, 8192.0)

    private val MEGABIT_PER_SECOND = Unit(megabit_per_second, symbol_megabit_per_second, 1e6)

    private val MEBIBIT_PER_SECOND = Unit(mebibit_per_second, symbol_mebibit_per_second, 1.048576e6)

    private val MEGABYTE_PER_SECOND = Unit(megabyte_per_second, symbol_megabyte_per_second, 8e6)

    private val MEBIBYTE_PER_SECOND = Unit(mebibyte_per_second, symbol_mebibyte_per_second, 8.38860836)

    private val GIGABIT_PER_SECOND = Unit(gigabit_per_second, symbol_gigabit_per_second, 1e9)

    private val GIBIBIT_PER_SECOND = Unit(gibibit_per_second, symbol_gibibit_per_second, 1.073741824e9)

    private val GIGABYTE_PER_SECOND = Unit(gigabyte_per_second, symbol_gigabyte_per_second, 8e9)

    private val GIBIBYTE_PER_SECOND = Unit(gibibyte_per_second, symbol_gibibyte_per_second, 8.589934592e9)

    private val TERABIT_PER_SECOND = Unit(terabit_per_second, symbol_terabit_per_second, 1e12)

    private val TEBIBIT_PER_SECOND = Unit(tebibit_per_second, symbol_tebibit_per_second, 1.099511627776e12)

    private val TERABYTE_PER_SECOND = Unit(terabyte_per_second, symbol_terabyte_per_second, 8e12)

    private val TEBIBYTE_PER_SECOND = Unit(tebibyte_per_second, symbol_tebibyte, 8.796093022208e12)

    //----------------------------------------------------------------------------------------------

    private val RADIAN = Unit(radian, symbol_radian)

    private val DEGREE = Unit(degree, symbol_degree, 17.453293e-3)

    private val ARCMINUTE = Unit(arcminute, symbol_arcminute, 0.290888e-3)

    private val ARCSECOND = Unit(arcsecond, symbol_arcsecond, 4.848137e-6)

    //----------------------------------------------------------------------------------------------

    private val KILOGRAM_PER_CUBIC_METRE = Unit(kilogram_per_cubic_metre, symbol_kilogram_per_cubic_metre)

    private val KILOGRAM_PER_LITRE = Unit(kilogram_per_litre, symbol_kilogram_per_litre, 1000.0)

    private val OUNCE_PER_CUBIC_FOOT = Unit(ounce_per_cubic_foot, symbol_ounce_per_cubic_foot, 1.001153961)

    private val OUNCE_PER_CUBIC_INCH = Unit(ounce_per_cubic_inch, symbol_ounce_per_cubic_inch, 1.729994044e3)

    private val POUND_PER_CUBIC_FOOT = Unit(pound_per_cubic_foot, symbol_pound_per_cubic_foot, 16.01846337)

    private val POUND_PER_CUBIC_INCH = Unit(pound_per_cubic_inch, symbol_pound_per_cubic_inch, 2.76799047134)

    private val OUNCE_PER_IMPERIAL_GALLON = Unit(ounce_per_imperial_gallon, symbol_ounce_per_imperial_gallon, 6.236023291)

    private val OUNCE_PER_US_GALLON = Unit(ounce_per_us_gallon, symbol_ounce_per_us_gallon, 7.489151707)

    private val POUND_PER_IMPERIAL_GALLON = Unit(pound_per_imperial_gallon, symbol_pound_per_imperial_gallon, 99.77637266)

    private val POUND_PER_US_GALLON = Unit(pound_per_us_gallon, symbol_pound_per_us_gallon, 119.8264273)

    //----------------------------------------------------------------------------------------------

    private val HERTZ = Unit(hertz, symbol_hertz)

    private val KILOHERTZ = Unit(kilohertz, symbol_kilohertz, 1e3)

    private val MEGAHERTZ = Unit(megahertz, symbol_megahertz, 1e6)

    private val GIGAHERTZ = Unit(gigahertz, symbol_gigahertz, 1e9)

    private val REVOLUTION_PER_MINUTE = Unit(revolution_per_minute, symbol_revolutions_per_minute, 0.104719755)

    //----------------------------------------------------------------------------------------------

    private val CUBIC_METRE_PER_SECOND = Unit(cubic_metre_per_second, symbol_cubic_metre_per_second)

    private val LITRE_PER_MINUTE = Unit(litre_per_minute, symbol_litre_per_minute, 1.667e-5)

    private val IMPERIAL_GALLON_PER_MINUTE = Unit(imperial_gallon_per_minute, symbol_imperial_gallon_per_minute, 7.577e-5)

    private val US_GALLON_PER_MINUTE = Unit(us_gallon_per_minute, symbol_us_gallon_per_minute, 6.309e-5)

    //----------------------------------------------------------------------------------------------

    private val METRE_PER_SECOND_SQUARED = Unit(metre_per_second_squared, symbol_metre_per_second_squared)

    private val GALILEO = Unit(galileo, symbol_galileo, 1e-2)

    private val STANDARD_GRAVITY = Unit(standard_gravity, symbol_standard_gravity, 9.80665)

    private val MILE_PER_HOUR_PER_SECOND = Unit(mile_per_hour_per_second, symbol_mile_per_hour_per_second, 0.44704)

    private val KNOT_PER_SECOND = Unit(knot_per_second, symbol_knot_per_second, 0.514444)

    //----------------------------------------------------------------------------------------------

    private val NEWTON = Unit(newton, symbol_newton)

    private val DYNE = Unit(dyne, symbol_dyne, 1e-5)

    private val KILOPOND = Unit(kilopond, symbol_kilopond, 9.80665)

    private val POUNDAL = Unit(poundal, symbol_poundal, 0.138254954376)

    private val POUND_FORCE = Unit(pound_force, symbol_pound_force, 4.4482216152605)

    private val OUNCE_FORCE = Unit(ounce_force, symbol_ounce_force, 0.27801385095378125)

    //----------------------------------------------------------------------------------------------

    private val PASCAL = Unit(pascal, symbol_pascal)

    private val POUND_PER_SQUARE_INCH = Unit(pound_per_square_inch, symbol_pound_per_square_inch, 6.894757e3)

    private val ATMOSPHERE = Unit(atmosphere, symbol_atmosphere, 101325.0)

    private val BAR = Unit(bar, symbol_bar, 1e5)

    private val MILLIMETRE_OF_MERCURY = Unit(millimetre_of_mercury, symbol_millimetre_of_mercury, 133.3224)

    private val KILOPASCAL = Unit(kilopascal, symbol_kilopascal, 1e3)

    private val MEGAPASCAL = Unit(megapascal, symbol_megapascal, 1e6)

    //----------------------------------------------------------------------------------------------

    private val FOOT_POUND = Unit(foot_pound, symbol_foot_pound, 1.3558179483314004)

    private val INCH_POUND = Unit(inch_pound, symbol_inch_pound, 0.1129848290276167)

    private val NEWTON_METRE = Unit(newton_metre, symbol_newton_metre)

    private val KILOPOND_METRE = Unit(kilopond_metre, symbol_kilopond_metre, 9.80665)

    //----------------------------------------------------------------------------------------------

    private val JOULE = Unit(joule, symbol_joule)

    private val ERG = Unit(erg, symbol_erg, 1e-7)

    private val KILOWATT_HOUR = Unit(kilowatt_hour, symbol_kilowatt_hour, 3.6e6)

    private val MEGAWATT_HOUR = Unit(megawatt_hour, symbol_megawatt_hour, 3.6e9)

    private val CALORIE = Unit(calorie, symbol_calorie, 4.1868)

    private val KILOCALORIE = Unit(kilocalorie, symbol_kilocalorie, 4.1868e3)

    private val BARREL_OF_OIL_EQUIVALENT = Unit(barrel_of_oil_equivalent, symbol_barrel_of_oil_equivalent, 6.12e9)

    private val BRITISH_THERMAL_UNIT = Unit(british_thermal_unit, symbol_british_thermal_unit, 1.05505585262e3)

    private val ELECTRONVOLT = Unit(electronvolt, symbol_electronvolt, 1.60217656535e-19)

    private val IMPERIAL_GALLON_ATMOSPHERE = Unit(imperial_gallon_atmosphere, symbol_imperial_gallon_atmosphere, 460.63256925)

    private val US_GALLON_ATMOSPHERE = Unit(us_gallon_atmosphere, symbol_us_gallon_atmosphere, 383.5568490138)

    //----------------------------------------------------------------------------------------------

    private val WATT = Unit(watt, symbol_watt)

    private val KILOWATT = Unit(kilowatt, symbol_kilowatt, 1e3)

    private val MEGAWATT = Unit(megawatt, symbol_megawatt, 1e6)

    private val HORSEPOWER = Unit(horsepower, symbol_horsepower, 735.49875)

    private val ERG_PER_SECOND = Unit(erg_per_second, symbol_erg_per_second, 1e-7)

    private val CALORIE_PER_SECOND = Unit(calorie_per_second, symbol_calorie_per_second, 4.1868)

    //----------------------------------------------------------------------------------------------

    private val AMPERE = Unit(ampere, symbol_ampere)

    private val ABAMPERE = Unit(abampere, symbol_abampere, 10.0)

    private val STATAMPERE = Unit(statampere, symbol_statampere, 3.335641e-10)

    //----------------------------------------------------------------------------------------------

    private val COULOMB = Unit(coulomb, symbol_coulomb)

    private val ABCOULOMB = Unit(abcoulomb, symbol_abcoulomb, 10.0)

    private val STATCOULOMB = Unit(statcoulomb, symbol_statcoulomb, 3.335641e-10)

    private val FARADAY = Unit(faraday, symbol_faraday, 96485.3383)

    private val MILLIAMPERE_HOUR = Unit(milliampere_hour, symbol_milliampere_hour, 3.6)

    //----------------------------------------------------------------------------------------------

    private val VOLT = Unit(volt, symbol_volt)

    private val ABVOLT = Unit(abvolt, symbol_abvolt, 1e-8)

    private val STATVOLT = Unit(statvolt, symbol_statvolt, 299.792458)

    //----------------------------------------------------------------------------------------------

    private val CANDELA_PER_SQUARE_METRE = Unit(candela_per_square_metre, symbol_candela_per_square_metre)

    private val STILB = Unit(stilb, symbol_stilb, 1e4)

    private val LAMBERT = Unit(lambert, symbol_lambert, 3183.0988618)

    private val FOOTLAMBERT = Unit(footlambert, symbol_footlambert, 3.4262590996)

    //----------------------------------------------------------------------------------------------

    private val LUX = Unit(lux, symbol_lux)

    private val PHOT = Unit(phot, symbol_phot, 1e4)

    private val FOOTCANDLE = Unit(footcandle, symbol_footcandle, 10.763910417)

    //----------------------------------------------------------------------------------------------

    private val GRAY = Unit(gray, symbol_gray)

    private val RAD = Unit(rad, symbol_rad, 0.01)

    private val SIEVERT = Unit(sievert, symbol_sievert)

    private val REM = Unit(rem, symbol_rem, 0.01)

    //----------------------------------------------------------------------------------------------

    private val BECQUEREL = Unit(becquerel, symbol_becquerel)

    private val CURIE = Unit(curie, symbol_curie, 3.7e10)

    private val RUTHERFORD = Unit(rutherford, symbol_rutherford, 1e6)

    //----------------------------------------------------------------------------------------------

    private val UNITS_LENGTH = arrayOf(

            METRE,

            KILOMETRE,

            MILE,

            YARD,

            FOOT,

            INCH,

            CENTIMETRE,

            MILLIMETRE,

            MICROMETRE,

            ANGSTROM,

            AU,

            LIGHT_YEAR,

            PARSEC,

            NANOMETRE,

            PICOMETRE,

            FERMI,

            FATHOM,

            FURLONG,

            NAUTICAL_MILE
    )

    private val UNITS_AREA = arrayOf(

            SQUARE_METRE,

            SQUARE_KILOMETRE,

            ARE,

            HECTARE,

            ACRE,

            CUERDA,

            SQUARE_YARD,

            SQUARE_FOOT,

            SQUARE_INCH
    )

    private val UNITS_VOLUME = arrayOf(

            CUBIC_METRE,

            LITRE,

            MILLILITRE,

            CUBIC_FOOT,

            CUBIC_INCH,

            IMPERIAL_GALLON,

            US_GALLON,

            IMPERIAL_QUART,

            US_QUART,

            IMPERIAL_PINT,

            US_PINT,

            IMPERIAL_FLUID_OUNCE,

            US_FLUID_OUNCE,

            IMPERIAL_TABLESPOON,

            US_TABLESPOON,

            IMPERIAL_TEASPOON,

            US_TEASPOON
    )

    private val UNITS_MASS = arrayOf(

            KILOGRAM,

            STONE,

            POUND,

            OUNCE,

            IMPERIAL_TON,

            US_TON,

            TONNE,

            GRAM,

            MILLIGRAM,

            MICROGRAM,

            CARAT,

            DRAM,

            GRAIN,

            ATOMIC_MASS_UNIT,

            ELECTRON_REST_MASS
    )

    private val UNITS_TIME = arrayOf(

            SECOND,

            MINUTE,

            HOUR,

            DAY,

            WEEK,

            MONTH,

            YEAR,

            DECADE,

            CENTURY
    )

    private val UNITS_SPEED = arrayOf(

            METRE_PER_SECOND,

            MILE_PER_HOUR,

            KILOMETRE_PER_HOUR,

            FOOT_PER_SECOND,

            KNOT,

            SPEED_OF_LIGHT,

            SPEED_OF_SOUND
    )

    private val UNITS_TEMPERATURE = arrayOf(

            KELVIN,

            CELSIUS,

            FAHRENHEIT
    )

    private val UNITS_FUEL = arrayOf(

            KILOMETRE_PER_LITRE,

            MILE_PER_IMPERIAL_GALLON,

            MILE_PER_US_GALLON
    )

    private val UNITS_STORAGE = arrayOf(

            BIT,

            BYTE,

            KILOBIT,

            KIBIBIT,

            KILOBYTE,

            KIBIBYTE,

            MEGABIT,

            MEBIBIT,

            MEGABYTE,

            MEBIBYTE,

            GIGABIT,

            GIBIBIT,

            GIGABYTE,

            GIBIBYTE,

            TERABIT,

            TEBIBIT,

            TERABYTE,

            TEBIBYTE,

            PETABIT,

            PEBIBIT,

            PETABYTE,

            PEBIBYTE
    )

    private val UNITS_BITRATE = arrayOf(

            KILOBIT_PER_SECOND,

            KIBIBIT_PER_SECOND,

            KILOBYTE_PER_SECOND,

            KIBIBYTE_PER_SECOND,

            MEGABIT_PER_SECOND,

            MEBIBIT_PER_SECOND,

            MEGABYTE_PER_SECOND,

            MEBIBYTE_PER_SECOND,

            GIGABIT_PER_SECOND,

            GIBIBIT_PER_SECOND,

            GIGABYTE_PER_SECOND,

            GIBIBYTE_PER_SECOND,

            TERABIT_PER_SECOND,

            TEBIBIT_PER_SECOND,

            TERABYTE_PER_SECOND,

            TEBIBYTE_PER_SECOND
    )

    private val UNITS_ANGLE = arrayOf(

            RADIAN,

            DEGREE,

            ARCMINUTE,

            ARCSECOND
    )

    private val UNITS_DENSITY = arrayOf(

            KILOGRAM_PER_CUBIC_METRE,

            KILOGRAM_PER_LITRE,

            OUNCE_PER_CUBIC_FOOT,

            OUNCE_PER_CUBIC_INCH,

            POUND_PER_CUBIC_FOOT,

            POUND_PER_CUBIC_INCH,

            OUNCE_PER_IMPERIAL_GALLON,

            OUNCE_PER_US_GALLON,

            POUND_PER_IMPERIAL_GALLON,

            POUND_PER_US_GALLON
    )

    private val UNITS_FREQUENCY = arrayOf(

            HERTZ,

            KILOHERTZ,

            MEGAHERTZ,

            GIGAHERTZ,

            REVOLUTION_PER_MINUTE
    )

    private val UNITS_FLOW = arrayOf(

            CUBIC_METRE_PER_SECOND,

            LITRE_PER_MINUTE,

            IMPERIAL_GALLON_PER_MINUTE,

            US_GALLON_PER_MINUTE
    )

    private val UNITS_ACCELERATION = arrayOf(

            METRE_PER_SECOND_SQUARED,

            GALILEO,

            STANDARD_GRAVITY,

            MILE_PER_HOUR_PER_SECOND,

            KNOT_PER_SECOND
    )

    private val UNITS_FORCE = arrayOf(

            NEWTON,

            DYNE,

            KILOPOND,

            POUNDAL,

            POUND_FORCE,

            OUNCE_FORCE
    )

    private val UNITS_PRESSURE = arrayOf(

            PASCAL,

            POUND_PER_SQUARE_INCH,

            ATMOSPHERE,

            BAR,

            MILLIMETRE_OF_MERCURY,

            KILOPASCAL,

            MEGAPASCAL
    )

    private val UNITS_TORQUE = arrayOf(

            FOOT_POUND,

            INCH_POUND,

            NEWTON_METRE,

            KILOPOND_METRE
    )

    private val UNITS_ENERGY = arrayOf(

            JOULE,

            ERG,

            KILOWATT_HOUR,

            MEGAWATT_HOUR,

            CALORIE,

            KILOCALORIE,

            BARREL_OF_OIL_EQUIVALENT,

            BRITISH_THERMAL_UNIT,

            ELECTRONVOLT,

            IMPERIAL_GALLON_ATMOSPHERE,

            US_GALLON_ATMOSPHERE
    )

    private val UNITS_POWER = arrayOf(

            WATT,

            KILOWATT,

            MEGAWATT,

            HORSEPOWER,

            ERG_PER_SECOND,

            CALORIE_PER_SECOND
    )

    private val UNITS_CURRENT = arrayOf(

            AMPERE,

            ABAMPERE,

            STATAMPERE
    )

    private val UNITS_CHARGE = arrayOf(

            COULOMB,

            ABCOULOMB,

            STATCOULOMB,

            FARADAY,

            MILLIAMPERE_HOUR
    )

    private val UNITS_VOLTAGE = arrayOf(

            VOLT,

            ABVOLT,

            STATVOLT
    )

    private val UNITS_LUMINANCE = arrayOf(

            CANDELA_PER_SQUARE_METRE,

            STILB,

            LAMBERT,

            FOOTLAMBERT
    )

    private val UNITS_ILLUMINANCE = arrayOf(

            LUX,

            PHOT,

            FOOTCANDLE
    )

    private val UNITS_RADIATION = arrayOf(

            GRAY,

            RAD,

            SIEVERT,

            REM
    )

    private val UNITS_RADIOACTIVITY = arrayOf(

            BECQUEREL,

            CURIE,

            RUTHERFORD
    )

    //----------------------------------------------------------------------------------------------

    private val LENGTH = Quantity(

            id = R.id.navigation_length,

            name = R.string.navigation_length,

            color = R.color.blue_500,

            colorDark = R.color.blue_700,

            shortcutIcon = R.drawable.ic_shortcut_length,

            units = UNITS_LENGTH,
            
            rank = 100
    )

    private val AREA = Quantity(

            id = R.id.navigation_area,

            name = R.string.navigation_area,

            color = R.color.green_500,

            colorDark = R.color.green_700,

            shortcutIcon = R.drawable.ic_shortcut_area,

            units = UNITS_AREA,
            
            rank = 101
    )

    private val VOLUME = Quantity(

            id = R.id.navigation_volume,

            name = R.string.navigation_volume,

            color = R.color.light_blue_500,

            colorDark = R.color.light_blue_700,

            shortcutIcon = R.drawable.ic_shortcut_volume,

            units = UNITS_VOLUME,
            
            rank = 102
    )

    private val MASS = Quantity(

            id = R.id.navigation_mass,

            name = R.string.navigation_mass,

            color = R.color.red_500,

            colorDark = R.color.red_700,

            shortcutIcon = R.drawable.ic_shortcut_mass,

            units = UNITS_MASS,
            
            rank = 103
    )

    private val TIME = Quantity(

            id = R.id.navigation_time,

            name = R.string.navigation_time,

            color = R.color.amber_500,

            colorDark = R.color.amber_700,

            shortcutIcon = R.drawable.ic_shortcut_time,

            units = UNITS_TIME,
            
            rank = 104
    )

    private val SPEED = Quantity(

            id = R.id.navigation_speed,

            name = R.string.navigation_speed,

            color = R.color.deep_orange_500,

            colorDark = R.color.deep_orange_700,

            shortcutIcon = R.drawable.ic_shortcut_speed,

            units = UNITS_SPEED,
            
            rank = 105
    )

    private val TEMPERATURE = Quantity(

            id = R.id.navigation_temperature,

            name = R.string.navigation_temperature,

            color = R.color.cyan_500,

            colorDark = R.color.cyan_700,

            shortcutIcon = R.drawable.ic_shortcut_temperature,

            units = UNITS_TEMPERATURE,
            
            rank = 106
    )

    private val FUEL = Quantity(

            id = R.id.navigation_fuel,

            name = R.string.navigation_fuel,

            color = R.color.lime_500,

            colorDark = R.color.lime_700,

            shortcutIcon = R.drawable.ic_shortcut_fuel,

            units = UNITS_FUEL,
            
            rank = 107
    )

    private val STORAGE = Quantity(

            id = R.id.navigation_storage,

            name = R.string.navigation_storage,

            color = R.color.teal_500,

            colorDark = R.color.teal_700,

            shortcutIcon = R.drawable.ic_shortcut_storage,

            units = UNITS_STORAGE,
            
            rank = 108
    )

    private val BITRATE = Quantity(

            id = R.id.navigation_bitrate,

            name = R.string.navigation_bitrate,

            color = R.color.amber_500,

            colorDark = R.color.amber_700,

            shortcutIcon = R.drawable.ic_shortcut_bitrate,

            units = UNITS_BITRATE,
            
            rank = 109
    )

    private val ANGLE = Quantity(

            id = R.id.navigation_angle,

            name = R.string.navigation_angle,

            color = R.color.red_500,

            colorDark = R.color.red_700,

            shortcutIcon = R.drawable.ic_shortcut_angle,

            units = UNITS_ANGLE,
            
            rank = 200
    )

    private val DENSITY = Quantity(

            id = R.id.navigation_density,

            name = R.string.navigation_density,

            color = R.color.blue_500,

            colorDark = R.color.blue_700,

            shortcutIcon = R.drawable.ic_shortcut_density,

            units = UNITS_DENSITY,
            
            rank = 201
    )

    private val FREQUENCY = Quantity(

            id = R.id.navigation_frequency,

            name = R.string.navigation_frequency,

            color = R.color.green_500,

            colorDark = R.color.green_700,

            shortcutIcon = R.drawable.ic_shortcut_frequency,

            units = UNITS_FREQUENCY,
            
            rank = 202
    )

    private val FLOW = Quantity(

            id = R.id.navigation_flow,

            name = R.string.navigation_flow,

            color = R.color.light_blue_500,

            colorDark = R.color.light_blue_700,

            shortcutIcon = R.drawable.ic_shortcut_flow,

            units = UNITS_FLOW,
            
            rank = 203
    )

    private val ACCELERATION = Quantity(

            id = R.id.navigation_acceleration,

            name = R.string.navigation_acceleration,

            color = R.color.orange_500,

            colorDark = R.color.orange_700,

            shortcutIcon = R.drawable.ic_shortcut_acceleration,

            units = UNITS_ACCELERATION,
            
            rank = 204
    )

    private val FORCE = Quantity(

            id = R.id.navigation_force,

            name = R.string.navigation_force,

            color = R.color.teal_500,

            colorDark = R.color.teal_700,

            shortcutIcon = R.drawable.ic_shortcut_force,

            units = UNITS_FORCE,
            
            rank = 205
    )

    private val PRESSURE = Quantity(

            id = R.id.navigation_pressure,

            name = R.string.navigation_pressure,

            color = R.color.cyan_500,

            colorDark = R.color.cyan_700,

            shortcutIcon = R.drawable.ic_shortcut_pressure,

            units = UNITS_PRESSURE,
            
            rank = 206
    )

    private val TORQUE = Quantity(

            id = R.id.navigation_torque,

            name = R.string.navigation_torque,

            color = R.color.yellow_500,

            colorDark = R.color.yellow_700,

            shortcutIcon = R.drawable.ic_shortcut_torque,

            units = UNITS_TORQUE,
            
            rank = 207
    )

    private val ENERGY = Quantity(

            id = R.id.navigation_energy,

            name = R.string.navigation_energy,

            color = R.color.green_500,

            colorDark = R.color.green_700,

            shortcutIcon = R.drawable.ic_shortcut_energy,

            units = UNITS_ENERGY,
            
            rank = 208
    )

    private val POWER = Quantity(

            id = R.id.navigation_power,

            name = R.string.navigation_power,

            color = R.color.red_500,

            colorDark = R.color.red_700,

            shortcutIcon = R.drawable.ic_shortcut_power,

            units = UNITS_POWER,
            
            rank = 209
    )

    private val CURRENT = Quantity(

            id = R.id.navigation_current,

            name = R.string.navigation_current,

            color = R.color.yellow_500,

            colorDark = R.color.yellow_700,

            shortcutIcon = R.drawable.ic_shortcut_current,

            units = UNITS_CURRENT,
            
            rank = 210
    )

    private val CHARGE = Quantity(

            id = R.id.navigation_charge,

            name = R.string.navigation_charge,

            color = R.color.light_green_500,

            colorDark = R.color.light_green_700,

            shortcutIcon = R.drawable.ic_shortcut_charge,

            units = UNITS_CHARGE,

            rank = 211
    )

    private val VOLTAGE = Quantity(

            id = R.id.navigation_voltage,

            name = R.string.navigation_voltage,

            color = R.color.orange_500,

            colorDark = R.color.orange_700,

            shortcutIcon = R.drawable.ic_shortcut_voltage,

            units = UNITS_VOLTAGE,

            rank = 212
    )

    private val LUMINANCE = Quantity(

            id = R.id.navigation_luminance,

            name = R.string.navigation_luminance,

            color = R.color.amber_500,

            colorDark = R.color.amber_700,

            shortcutIcon = R.drawable.ic_shortcut_luminance,

            units = UNITS_LUMINANCE,

            rank = 213
    )

    private val ILLUMINANCE = Quantity(

            id = R.id.navigation_illuminance,

            name = R.string.navigation_illuminance,

            color = R.color.lime_500,

            colorDark = R.color.lime_700,

            shortcutIcon = R.drawable.ic_shortcut_illuminance,

            units = UNITS_ILLUMINANCE,

            rank = 214
    )

    private val RADIATION = Quantity(

            id = R.id.navigation_radiation,

            name = R.string.navigation_radiation,

            color = R.color.deep_orange_500,

            colorDark = R.color.deep_orange_700,

            shortcutIcon = R.drawable.ic_shortcut_radiation,

            units = UNITS_RADIATION,

            rank = 215
    )

    private val RADIOACTIVITY = Quantity(

            id = R.id.navigation_radioactivity,

            name = R.string.navigation_radioactivity,

            color = R.color.yellow_500,

            colorDark = R.color.yellow_700,

            shortcutIcon = R.drawable.ic_shortcut_radioactivity,

            units = UNITS_RADIOACTIVITY,

            rank = 216
    )

    //----------------------------------------------------------------------------------------------

    private val idMap = hashMapOf(

            R.id.navigation_length to LENGTH,

            R.id.navigation_area to AREA,

            R.id.navigation_volume to VOLUME,

            R.id.navigation_mass to MASS,

            R.id.navigation_time to TIME,

            R.id.navigation_speed to SPEED,

            R.id.navigation_temperature to TEMPERATURE,

            R.id.navigation_fuel to FUEL,

            R.id.navigation_storage to STORAGE,

            R.id.navigation_bitrate to BITRATE,

            R.id.navigation_angle to ANGLE,

            R.id.navigation_density to DENSITY,

            R.id.navigation_frequency to FREQUENCY,

            R.id.navigation_flow to FLOW,

            R.id.navigation_acceleration to ACCELERATION,

            R.id.navigation_force to FORCE,

            R.id.navigation_pressure to PRESSURE,

            R.id.navigation_torque to TORQUE,

            R.id.navigation_energy to ENERGY,

            R.id.navigation_power to POWER,

            R.id.navigation_current to CURRENT,

            R.id.navigation_charge to CHARGE,

            R.id.navigation_voltage to VOLTAGE,

            R.id.navigation_luminance to LUMINANCE,

            R.id.navigation_illuminance to ILLUMINANCE,

            R.id.navigation_radiation to RADIATION,

            R.id.navigation_radioactivity to RADIOACTIVITY
    )
}