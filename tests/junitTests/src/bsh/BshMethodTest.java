package bsh;

import junit.framework.Assert;

import org.junit.Test;

public class BshMethodTest {

   /**
    * Verifies that subclasses are not considered equal to superclass interfaces
    * with a (potential) subset of the subclasses fields.
    */
   @SuppressWarnings("serial")
   @Test
   public void testEqualsObject_subclassEquality() {
      // define a simple subclass of BshMethod:
      class SubMethod extends BshMethod {
         public SubMethod(String name, Class returnType, String[] paramNames,
               Class[] paramTypes, BSHBlock methodBody,
               NameSpace declaringNameSpace, Modifiers modifiers) {
            super(name, returnType, paramNames, paramTypes, methodBody,
                  declaringNameSpace, modifiers);
         }
      }

      final String name = "testMethod";
      final BshMethod subInst =
            new SubMethod(name, Integer.class, new String[] {}, new Class[] {},
                  null, null, null);
      final BshMethod supInst =
            new BshMethod(name, Integer.class, new String[] {}, new Class[] {},
                  null, null, null);

      Assert.assertFalse("Subclasses should not be equal to super classes",
            supInst.equals(subInst));
   }
   
   /**
    * Very simple test to verify hashcode contract.
    */
   @Test
   public void testHashCode_contract() {
      final String name = "testMethod";
      final BshMethod method1 = new BshMethod(name, 
            Integer.class, new String[]{}, new Class[]{}, null, null, null);
      final BshMethod method2 = new BshMethod(name, 
            Integer.class, new String[]{}, new Class[]{}, null, null, null);
      
      Assert.assertTrue("precondition check for test failed.", 
            method2.equals(method1));
      Assert.assertEquals("Equal classes should have equal hashcodes",
            method2.hashCode(), method1.hashCode());
   }
}
