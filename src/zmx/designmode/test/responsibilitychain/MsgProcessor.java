package zmx.designmode.test.responsibilitychain;

public class MsgProcessor {

	private String msg;

	public MsgProcessor(String msg) {
		this.msg = msg;
	}

	public String process() {
		String r = msg;
		// 过滤msg中的HTML标记
		r = r.replaceAll("<.*>", "");
		
		// 过滤敏感词
		r = r.replace("敏感信息", "").replace("被就业", "就业");
		return r;
	}

}
