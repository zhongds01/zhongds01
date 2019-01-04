package com.asiainfo.sacenter.shcmcc.util;

/**
 * Created by Uncle.Le on 2017/8/10.
 */

        import com.ai.aif.csf.api.server.request.executor.UniformContext;
        import com.ai.aif.csf.api.server.request.filterchain.IFilterChain;
        import com.ai.aif.csf.common.exception.CsfException;
        import com.ai.aif.csf.executor.request.filter.params.mapping.TransportParamsMappingFilter;
        import com.ai.appframe2.common.AIConfigManager;
        import org.apache.commons.logging.Log;
        import org.apache.commons.logging.LogFactory;

        import java.util.Collection;
        import java.util.Iterator;
        import java.util.Map;
        import java.util.regex.Pattern;

public class SHParamMappingFilter extends TransportParamsMappingFilter  {

    private transient static Log log = LogFactory.getLog(SHParamMappingFilter.class);

    private static String DEFAULT_ILLEGAL_CHAR_CHECK = "script|select";


    private static Pattern PATTERN =Pattern.compile(DEFAULT_ILLEGAL_CHAR_CHECK);
    static{

        String illegal_char_check = null;
        try {
            illegal_char_check = AIConfigManager.getConfigItem("ILLEGAL_CHAR_CHECK");
            PATTERN	=Pattern.compile(illegal_char_check);
        } catch (Exception e) {
            PATTERN =Pattern.compile(DEFAULT_ILLEGAL_CHAR_CHECK);
            if(log.isErrorEnabled()){
                log.error(e);
            }
        }

    }

    @Override
    public void doFilter(UniformContext reqContext, IFilterChain Chain) throws CsfException {
        doCheck(reqContext.getBusinessParams());
        super.doFilter(reqContext, Chain);
    }

    private void doCheck(Object busiparam) throws CsfException {

        if (busiparam != null) {
            if (busiparam instanceof Map) {
                Collection keyset = ((Map) busiparam).keySet();
                Collection values = ((Map) busiparam).values();
                doCheck(keyset);
                doCheck(values);
            }else if(busiparam instanceof Collection){

                for(Iterator it = ((Collection)busiparam).iterator() ;it.hasNext(); ){
                    doCheck( it.next());
                }

            }else if(busiparam instanceof Object[]){
                for( Object object :(Object[])busiparam){
                    doCheck( object);
                }
            }else if(busiparam instanceof String){
                if(PATTERN.matcher(busiparam.toString()).find()){
                    throw new CsfException("csf9999","非法的入参:"+busiparam);
                }
            }
        }
    }

}
