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
package рф.эллиптика.ява.увм.компилятор.маркеры;

import java.rmi.RemoteException;

import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;

/**
 * Сопряжение <code>ТелеКомпиляторЯва</code> предназначено для вызова функционала компиляции объекта
 * {@linkplain javax.tools.JavaCompiler JavaCompiler}.
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеКомпиляторЯва extends СопряжениеТелеМаркер {
    /**
     * Создаёт план для задачи компиляции с заданными
     * компонентами и аргументами. Компиляция может не завершиться,
     * как это и описано в сопряжении CompilationTask.
     *
     * <p>Если предоставлен управляющий файлами, он должен быть способен обращаться со всеми
     * местами, определёнными в {@link StandardLocation}.
     *
     * <p>Note that annotation processing can process both the
     * compilation units of source code to be compiled, passed with
     * the {@code compilationUnits} parameter, as well as class
     * files, whose names are passed with the {@code classes}
     * parameter.
     *
     * @param вывод — Writer для дополнительного вывода от компилятора;
     * используй {@code System.err}, если {@code null}
     * @param fileManager a file manager; if {@code null} use the
     * compiler's standard filemanager
     * @param diagnosticListener a diagnostic listener; if {@code
     * null} use the compiler's default method for reporting
     * diagnostics
     * @param options compiler options, {@code null} means no options
     * @param classes names of classes to be processed by annotation
     * processing, {@code null} means no class names
     * @param compilationUnits the compilation units to compile, {@code
     * null} means no compilation units
     * @return an object representing the compilation
     * @throws RuntimeException if an unrecoverable error
     * occurred in a user supplied component.  The
     * {@linkplain Throwable#getCause() cause} will be the error in
     * user code.
     * @throws IllegalArgumentException if any of the options are invalid,
     * or if any of the given compilation units are of other kind than
     * {@linkplain JavaFileObject.Kind#SOURCE source}
     */
    ТелеЗадачаЯвак getTask(
			ТелеПисатель вывод,
            ТелеРаспорядительФайлов fileManager,
            ТелеДиагностирующийСлушатель<? super JavaFileObject> diagnosticListener,
            ТелеПеребираемое<?> options,
            ТелеПеребираемое<?> classes,
            ТелеПеребираемое<? extends JavaFileObject> compilationUnits,
            ТелеОкружение context
	) throws RemoteException;

}
