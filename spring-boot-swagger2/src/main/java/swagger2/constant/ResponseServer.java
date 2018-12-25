package swagger2.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel(value = "返回响应数据",description= "返回响应数据")
public class ResponseServer<T> implements Serializable {

    /**
     * 响应编码
     */
    @ApiModelProperty(value = "???",name = "resp_code")
    private Integer resp_code;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息,响应码[0 - 成功,1 - 失败,2 - 未知,3 - 参数错误,4 - 错误]resp_Code",name = "resp_msg")
    private String resp_msg;

    /**
     * 返回的数据对象
     */
    @ApiModelProperty(value = "返回数据对象",name = "resp_data")
    private T resp_data;

    private ResponseServer(Integer resp_code) {
        this.resp_code = resp_code;
    }

    private ResponseServer(Integer resp_code, T resp_data) {
        this.resp_code = resp_code;
        this.resp_data = resp_data;
    }

    private ResponseServer(Integer resp_code, String resp_msg) {
        this.resp_code = resp_code;
        this.resp_msg = resp_msg;
    }

    private ResponseServer(Integer resp_code, String resp_msg, T resp_data) {
        this.resp_code = resp_code;
        this.resp_msg = resp_msg;
        this.resp_data = resp_data;
    }


    public boolean judgeSuccess() {
        return this.resp_code == ResponseCode.SUCCESS.getCode();
    }

    public int getResp_Code() {
        return this.resp_code;
    }

    public String getResp_msg() {
        return this.resp_msg;
    }

    public T getResp_data() {
        return this.resp_data;
    }

    /**
     * 只会返回一个 code
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createBySuccess() {
        return new ResponseServer(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 会返回一个文本
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createBySuccess(String msg) {
        return new ResponseServer(ResponseCode.SUCCESS.getCode(), msg);
    }

    /**
     * 返回正确的数据
     *
     * @param resp_data
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createBySuccess(T resp_data) {
        return new ResponseServer(ResponseCode.SUCCESS.getCode(), resp_data);
    }

    /**
     * 既有提示  又有数据
     *
     * @param resp_msg
     * @param resp_data
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createBySuccess(String resp_msg, T resp_data) {
        return new ResponseServer(ResponseCode.SUCCESS.getCode(), resp_msg, resp_data);
    }

    /**
     * 返回错误code 以及描述
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createByError() {
        return new ResponseServer(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    /**
     * 返回错误code 以及提示信息
     *
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createByErrorMessage(String errorMsg) {
        return new ResponseServer(ResponseCode.ERROR.getCode(), errorMsg);
    }

    /**
     * 返回自定义code 以及错误提示
     *
     * @param errorCode
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> ResponseServer<T> createByErrorCodeMessage(int errorCode, String errorMsg) {
        return new ResponseServer(errorCode, errorMsg);
    }

}
