package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import conversion.EnglishToMetricConverter;

class EnglishToMetricConverterTester {

	@Test
    public void testFreezingConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double freezingF = 32.0;
        final double freezingC = 0.0;
        assertEquals(e.convertTemperature(freezingF), freezingC, 0.0001);        
    }

    @Test
    public void testBoilingConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double boilingF = 212.0;
        final double boilingC = 100.0;
        assertEquals(e.convertTemperature(boilingF), boilingC, 0.0001);        
    }
    
    @Test
    public void test40Conversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double boilingF = -40;
        final double boilingC = -40;
        assertEquals(e.convertTemperature(boilingF), boilingC, 0.0001);        
    }
    
    @Test
    public void test1MileConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double mile = 1;
        final double km = 1.609;
        assertEquals(e.convertDistance(mile), km, 0.0001);        
    }
    
    @Test
    public void test1KmConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double mile = 0.609;
        final double km = 0.98;
        assertEquals(e.convertDistance(mile), km, 0.001);       
    }
    
    @Test
    public void test8MileConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double mile = 8;
        final double km = 12.8748;
        assertEquals(e.convertDistance(mile), km, 0.01);       
    }
    
    @Test
    public void test2LbConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double lb = 2.2;
        final double kg = 1;
        assertEquals(e.convertWeight(lb), kg, 0.0001);       
    }

    @Test
    public void test1LbConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double lb = 1;
        final double kg = 0.453592;
        assertEquals(e.convertWeight(lb), kg, 0.01);       
    }
    
    @Test
    public void test200LbConversion() {
        EnglishToMetricConverter e = new EnglishToMetricConverter();
        final double lb = 200;
        final double kg = 90.9090;
        assertEquals(e.convertWeight(lb), kg, 0.0001);       
    }
}
