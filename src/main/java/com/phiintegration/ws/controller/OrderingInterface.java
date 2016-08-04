package com.phiintegration.ws.controller;

import com.phiintegration.ws.model.msUserState;
import com.phiintegration.ws.model.trOrderDetail;
import com.phiintegration.ws.model.trOrderHeader;

public interface OrderingInterface {

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#newOrderHeader(com.phiintegration.ws.model.order_header)
	 */
	int newOrderHeader(trOrderHeader oh);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#updateOrderHeader(com.phiintegration.ws.model.order_header)
	 */
	boolean updateOrderHeader(trOrderHeader oh);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#closeOrder(com.phiintegration.ws.model.order_header)
	 */
	boolean closeOrder(trOrderHeader oh);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#addOrderDetail(com.phiintegration.ws.model.order_detail)
	 */
	int addOrderDetail(trOrderDetail od);

	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#updateOrderDetail(com.phiintegration.ws.model.order_detail)
	 */
	boolean updateOrderDetail(trOrderDetail od);
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#readOrderHeader(com.phiintegration.ws.model.order_detail)
	 */
	int readOrderHeader(msUserState user);
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#deleteOrderHeader(com.phiintegration.ws.model.order_detail)
	 */
	boolean deleteOrder(trOrderHeader oh);
	
	/* (non-Javadoc)
	 * @see com.phiintegration.ws.model.OrderingInterface#updateHeaderTotal(com.phiintegration.ws.model.order_detail)
	 */
	boolean updateHeaderTotal(msUserState user);
	
	boolean checkStock(msUserState user);
	
	boolean minusStock(msUserState user);

}