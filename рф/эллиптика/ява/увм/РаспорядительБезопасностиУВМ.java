/*
 * Авторские права ↄ⃝ 2015, Антон Астафьев Ѱ҃
 *
 * Этот код — свободное программное обеспечение. Вы можете распространять и/или изменять его
 * при условии соблюдения положений Универсальной общественной лицензии GNU только 2-й версии, как
 * опубликовано Фондом Свободных Программ.
 *
 * Этот код распространяется с надеждой на то, что он будет полезен,
 * но БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ, даже без подразумеваемой гарантии КОММЕРЧЕСКОЙ ЦЕННОСТИ или
 * СООТВЕТСТВИЯ КОНКРЕТНОМУ ПРЕДНАЗНАЧЕНИЮ. Смотрите текст Универсальной общественной лицензии GNU
 * 2-й версии для подробного объяснения (копия включена в файл ЛИЦЕНЗИЯ, поставляемый с этим кодом).
 *
 */

/**
 * 
 */
package рф.эллиптика.ява.увм;

import java.lang.reflect.ReflectPermission;
import java.rmi.RMISecurityManager;
import java.security.Permission;

import sun.reflect.Reflection;
import sun.security.util.SecurityConstants;

/**
 * Тип <code>РаспорядительБезопасностиУВМ</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class РаспорядительБезопасностиУВМ extends RMISecurityManager {

    static final private java.security.Permission ACCESS_PERMISSION = new ReflectPermission("suppressAccessChecks");
    static final private java.security.Permission RUNITIME_PERMISSION_ACCESS_PKG_RMI_SERVER = new RuntimePermission("accessClassInPackage.sun.rmi.server");

	public РаспорядительБезопасностиУВМ() {
	}

	@Подмени
	public void checkPermission(Permission perm) {
		if ( SecurityConstants.CHECK_MEMBER_ACCESS_PERMISSION.equals(perm) || ACCESS_PERMISSION.equals(perm) ){
			Class<?> вызвавшийКласс = Reflection.getCallerClass(3);
			if ( проверьКласс(вызвавшийКласс) ){
				return;
			}
		}
		if (RUNITIME_PERMISSION_ACCESS_PKG_RMI_SERVER.equals(perm)){
			int элементСтэка = 2;
			boolean доверено = false;
			Class<?> вызвавшийКласс = Reflection.getCallerClass(элементСтэка);
			for (; вызвавшийКласс!=null && null == вызвавшийКласс.getClassLoader(); вызвавшийКласс = Reflection.getCallerClass(++элементСтэка) ){
			}
			if (проверьКласс(вызвавшийКласс) ){
				return;
			}
		}
        java.security.AccessController.checkPermission(perm);
	}
	
	private Строка пакет = getClass().getPackage().getName();
	
	private boolean проверьКласс(Class<?> класс){
		return (класс!=null && класс.getCanonicalName()!=null && класс.getCanonicalName().startsWith(пакет) && класс.getClassLoader() == getClass().getClassLoader()	);
	}
/*		
*/


}
