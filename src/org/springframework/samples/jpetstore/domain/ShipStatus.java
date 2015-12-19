/*
 * ShipStatus.java
 *
 * Created on 2006��10��1��, ����9:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.samples.jpetstore.domain;

/**
 * ����״̬ö�٣�
 * <p>
 *
 * <li>δ��: ���׻�����δͨ��У��
 * <li>�̶�: ����˫�����һ�£���������
 * <li>�Ѹ�����Ѿ����˴˽��׵Ŀ���
 * <li>������: �����Ѿ�����Ʒ����
 * <li>�յ�: �����Ѿ��ڹ涨���������յ���Ʒ
 * <li>�������: ���׵Ŀ����ѵ����������������
 *
 * State of a shipment under escrow������/��Լ��.
 *
 * @author pprun
 */
public enum ShipStatus {
    /** δ��: ���׻�����δͨ��У�� */
    PENDING("PENDING"),
    /** �̶�: ����˫�����һ�£��������� */
    AGREED("AGREED"),
    /** �Ѹ�����Ѿ����˴˽��׵Ŀ��� */
    PAYED("PAYED"), 
    /** ������: �����Ѿ�����Ʒ���� */
    IN_TRANSIT("IN_TRANSIT"),
    /** �յ�: �����Ѿ��ڹ涨���������յ���Ʒ */
    ACCEPTED("ACCEPTED"),
    /** �������: ���׵Ŀ����ѵ���������������� */
    COMPLETE("COMPLETE");
    
    private final String state;
    
    private ShipStatus(String state) {
      this.state = state;
    }
    
    public String value() {
      return state;
    }
    
    public String toString() {
      return state;
    }
}
