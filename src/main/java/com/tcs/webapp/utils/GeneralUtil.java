package com.tcs.webapp.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public final class GeneralUtil {

	private static GeneralUtil utilInst;

	public GeneralUtil() {
		synchronized (GeneralUtil.class) {
			if (utilInst == null) {
				utilInst = this;
			}
		}
	}

	public static GeneralUtil createInstance() {
		return new GeneralUtil();
	}

	public static GeneralUtil getInstance() {
		synchronized (GeneralUtil.class) {
			if (utilInst == null) {
				new GeneralUtil();
			}
		}
		return utilInst;
	}

	public boolean isNotEmptyArrayList(final List<?> list) {

		if (list == null || list.size() == 0) {
			return false;
		}
		return true;

	}

}
