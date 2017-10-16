package zmx.intercepter.test;

import java.util.ArrayList;

import java.util.List;

public class ActionInvocation {

	List<Interceptor> interceptors = new ArrayList<Interceptor>();

	int index = -1;

	Action action = new Action();

	public ActionInvocation() {

		this.interceptors.add(new FirstInterceptor());

		this.interceptors.add(new SecondInterceptor());

		this.interceptors.add(new ThirdInterceptor());

	}

	public void invoke() {

		if (index + 1 >= this.interceptors.size()) {

			action.execute();

		} else {

			index++;

			this.interceptors.get(index).intercept(this);

		}

	}

}
