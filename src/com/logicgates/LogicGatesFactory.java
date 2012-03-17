package com.logicgates;


public class LogicGatesFactory {

	public static IGate createGate(String gateType)
	{
		IGate gate = null;
		
		if(gateType.equalsIgnoreCase("OR"))
		{
			gate = null;
		}
		else if(gateType.equalsIgnoreCase("AND"))
		{
			gate = null;
		}
		else if(gateType.equalsIgnoreCase("NOR"))
		{
			gate = null;
		}
		else if(gateType.equalsIgnoreCase("NAND"))
		{
			gate = null;
		}
		else if(gateType.equalsIgnoreCase("XOR"))
		{
			gate = null;
		}		
		return gate;
	}

	
}
