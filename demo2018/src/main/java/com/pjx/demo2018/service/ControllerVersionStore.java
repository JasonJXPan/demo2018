package com.pjx.demo2018.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ControllerVersionStore {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerVersionStore.class);

	private ThreadLocal<ControllerVersion> versionStore = new ThreadLocal<>();
	
	public void setVersion(ControllerVersion version) {
		versionStore.set(version);
	}
	
	public ControllerVersion getVersion() {
		ControllerVersion version = versionStore.get();
		if (version == null) {
			logger.error("no stored version");
			throw new RuntimeException("no stored version");
		}
		logger.info("controller version is {}", version.name());
		return version;
	}

	/**
	 * 判断是否是后台下单
	 * @return
	 */
	public Boolean  isBackEndOrder() {
		ControllerVersion version = versionStore.get();
		if (version == null) {
			logger.info("There is no stored version. default backend order flag is false.");
			return false;
		}
		logger.info("controller version is {}", version.name());
		return ControllerVersion.V_BACK_END_ORDER==version;
	}

	/**
	 * 是否是一级票务过来的请求，包含下单、订单信息查询等
	 *
	 * @return
	 */
	public boolean isPxqOrder() {
		ControllerVersion version = versionStore.get();
		if (version == null) {
			return false;
		}
		return ControllerVersion.V1_PXQ==version;
	}


	public void clearVersion() {
		versionStore.remove();
	}
	
	public static enum ControllerVersion {
		V1,
		/**
		 * 电子票上线
		 */
		V1_1,
		/**
		 * 服务费上线， 兼容之前版本
		 */
		V1_2,
		/**
		 * 电子票核销码上线，兼容之前的版本
		 */
		V2,
		V_BACK_END_ORDER,
		/**
		 * 一级票务
		 */
		V1_PXQ;

	}
}
