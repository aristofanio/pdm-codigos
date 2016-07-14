package ag.pdm.mvp;

/**
 * Created by arigarcia on 7/13/16.
 */
public interface CalcPresenter {
    int getValue1();//captura valor
    int getValue2();//captura valor
    void sumClick();//ações
    void diffClick();//ações
    void showResult(int r);//result//ação de retorno
}
