package gastrodss;

import java.util.List;
import net.sf.clipsrules.jni.*;

public class Program {
	
	public static void main(String[] args) {
		Environment clips = new Environment();
		try {
			clips.load("program.clp");
			clips.reset();			
							
			clips.assertString("(Patient (name Pepe) (age 10) (alcohol_intake NO))");
			clips.assertString("(Patient (name Juan) (age 70) (alcohol_intake YES))");
			clips.watch(Environment.RULES);			
			
			clips.run();						
			
//			Print all older people
			List<FactAddressValue> f = clips.findAllFacts("?f","Patient","(>= ?f:age 65)");
			for (FactAddressValue p : f) 			{ 
				System.out.println("" + p.getSlotValue("name")); 
			}

			f = clips.findAllFacts("?p", "Patient", "(eq ?p:decision_taken TRUE)");
//			List<FactAddressValue> f = clips.findAllFacts("Patient");			
			for (FactAddressValue p : f) 			{ 
				System.out.println("" + p.getSlotValue("name")); 
			}		     

			
		} catch (CLIPSException e) { 
			e.printStackTrace();
			System.exit(1);
		}		
		
		
	}

}
