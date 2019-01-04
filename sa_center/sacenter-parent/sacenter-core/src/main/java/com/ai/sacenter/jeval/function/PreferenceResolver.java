package com.ai.sacenter.jeval.function;

import org.apache.log4j.Logger;

import com.ai.sacenter.jeval.FunctionResult;
import com.ai.sacenter.jeval.JevalEvaluator;
import com.ai.sacenter.jeval.VariableResolver;
import com.ai.sacenter.util.ReflectUtils;

public class PreferenceResolver implements VariableResolver {
	private static final Logger log = Logger.getLogger(PreferenceResolver.class);
	public PreferenceResolver() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.jeval.VariableResolver#resolveVariable(com.ai.sacenter.jeval.JevalEvaluator, java.lang.String)
	 */
	public FunctionResult resolveVariable(JevalEvaluator evaluator, String variableName) throws Exception {
		FunctionResult result = null;
		try
		{
			Object _variableValue = ReflectUtils.xPath( variableName, evaluator.getVariables() );
			if( _variableValue != null ){
				result = FunctionHelper.getResult(variableName, _variableValue);
			}
		}
		catch( java.lang.Exception exception ){
			log.error( exception.getMessage(), exception );
		}
		finally{
			
		}
		return result;
	}

}
