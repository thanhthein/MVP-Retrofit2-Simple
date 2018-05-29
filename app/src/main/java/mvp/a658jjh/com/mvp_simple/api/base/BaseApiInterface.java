package mvp.a658jjh.com.mvp_simple.api.base;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public interface BaseApiInterface<C> {

    boolean onResponse(C response);

    boolean onError(String error);

    boolean onNoInternet();
}
