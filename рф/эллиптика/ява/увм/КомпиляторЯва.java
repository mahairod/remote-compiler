/*
 * Авторские права ↄ⃝ 2014, Антон Астафьев Ѱ҃
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

/**
 * @author Антон Астафьев
 * @since Ява-8
 * Тип КомпиляторЯва предназначен для для удалённого вызова функционала компиляции объекта
 * {@linkplain javax.tools.JavaCompiler JavaCompiler}.
 *
 */
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileManager;
import javax.tools.StandardJavaFileManager;

import sun.security.util.SecurityConstants;
import рф.эллиптика.ява.увм.компилятор.вопл.ТелеКомпиляторЯваВопл;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеКомпиляторЯва;

import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.util.Options;
 
public class КомпиляторЯва {

	public static void main(Строка args[]) {
        System.out.println("Сервер УВМ запущен");

        // Создай и установи распорядителя безопасности
        if (System.getSecurityManager() == null) {
        	SecurityManager sm = new РаспорядительБезопасностиУВМ();
        	try{
            	sm.checkPermission(SecurityConstants.CHECK_MEMBER_ACCESS_PERMISSION);
        	} catch(SecurityException ex){}
            System.setSecurityManager(sm);
            System.out.println("Распорядитель безопасности установлен.");
        } else {
            System.out.println("Распорядитель безопасности уже существует.");
        }

        try { //специальный обработчик отклонений для создания реестра
            LocateRegistry.createRegistry(1099);
            System.out.println("Реестр УВМ Ява создан.");
        } catch (RemoteException e) {
            //ничего не делай, ошибка означает, что реестр уже существует
            System.out.println("Реестр УВМ Ява уже существует.");
        }

        try {
            //Породи КомпиляторЯва
        	ТелеКомпиляторЯва obj = new ТелеКомпиляторЯваВопл();
 
            // Привяжи экземпляр этого объекта к имени «КомпиляторЯва»
            Naming.rebind("//localhost/КомпиляторЯва", obj);
 
            System.out.println("Сервер-представитель привязан в реестре");
        } catch (Exception e) {
            System.err.println("Отклонение сервера УВМ:" + e);
            e.printStackTrace();
        }
    }

}