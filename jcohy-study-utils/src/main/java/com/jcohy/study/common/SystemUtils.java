package com.jcohy.study.common;


import java.io.File;

/**
 * Helpers for {  java.lang.System}.
 * If a system property cannot be read due to security restrictions, the corresponding field in this class will be set
 * to {  null} and a message will be written to {  System.err}.
 */
public class SystemUtils {

    /**
     * The prefix String for all Windows OS.
     */
    private static final String OS_NAME_WINDOWS_PREFIX = "Windows";

    // System property constants
    // -----------------------------------------------------------------------
    // These MUST be declared first. Other constants depend on this.
    /**
     * The System property key for the user home directory.
     */
    private static final String USER_HOME_KEY = "user.home";

    /**
     * The System property key for the user directory.
     */
    private static final String USER_DIR_KEY = "user.dir";

    /**
     * The System property key for the Java IO temporary directory.
     */
    private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";

    /**
     * The System property key for the Java home directory.
     */
    private static final String JAVA_HOME_KEY = "java.home";

    /**
     * The {  awt.toolkit} System Property.
     */
    public static final String AWT_TOOLKIT = getSystemProperty("awt.toolkit");

    /**
     * The {  file.encoding} System Property.
     * File encoding, such as {  Cp1252}.
     */
    public static final String FILE_ENCODING = getSystemProperty("file.encoding");

    /**
     * The {  file.separator} System Property.
     * The file separator is:
     * {  "/"} on UNIX
     * {  "\"} on Windows.
     */
    @Deprecated
    public static final String FILE_SEPARATOR = getSystemProperty("file.separator");

    /**
     * The {  java.awt.fonts} System Property.
     */
    public static final String JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");

    /**
     * The {  java.awt.graphicsenv} System Property.
     * @since 2.1
     */
    public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");

    /**
     * The {  java.awt.headless} System Property. The value of this property is the String {  "true"} or
     * {  "false"}.
     */
    public static final String JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");

    /**
     * The {  java.awt.printerjob} System Property.
     */
    public static final String JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");

    /**
     * The {  java.class.path} System Property. Java class path.
     */
    public static final String JAVA_CLASS_PATH = getSystemProperty("java.class.path");

    /**
     * The {  java.class.version} System Property. Java class format version number.
     */
    public static final String JAVA_CLASS_VERSION = getSystemProperty("java.class.version");

    /**
     * The {  java.compiler} System Property. Name of JIT compiler to use. First in JDK version 1.2. Not used in Sun
     * JDKs after 1.2.
     */
    public static final String JAVA_COMPILER = getSystemProperty("java.compiler");

    /**
     * The {  java.endorsed.dirs} System Property. Path of endorsed directory or directories.
     */
    public static final String JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");

    /**
     * The {  java.ext.dirs} System Property. Path of extension directory or directories.
     */
    public static final String JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");

    /**
     * <p>
     * The {  java.home} System Property. Java installation directory.
     * </p>
     */
    public static final String JAVA_HOME = getSystemProperty(JAVA_HOME_KEY);

    /**
     * <p>
     * The {  java.io.tmpdir} System Property. Default temp file path.
     */
    public static final String JAVA_IO_TMPDIR = getSystemProperty(JAVA_IO_TMPDIR_KEY);

    /**
     * <p>
     * The {  java.library.path} System Property. List of paths to search when loading libraries.
     */
    public static final String JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");

    /**
     * <p>
     * The {  java.runtime.name} System Property. Java Runtime Environment name.
     */
    public static final String JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");

    /**
     * The {  java.runtime.version} System Property. Java Runtime Environment version.
     */
    public static final String JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");

    /**
     * The { java.specification.name} System Property. Java Runtime Environment specification name.
     */
    public static final String JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");

    /**
     * <p>
     * The {   java.specification.vendor} System Property. Java Runtime Environment specification vendor.
     */
    public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");

    public static final String JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
    /**
     * <p>
     * The {  java.util.prefs.PreferencesFactory} System Property. A class name.
     */
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY =
        getSystemProperty("java.util.prefs.PreferencesFactory");

    /**
     * <p>
     * The {  java.vendor} System Property. Java vendor-specific string.
     */
    public static final String JAVA_VENDOR = getSystemProperty("java.vendor");

    /**
     * <p>
     * The {  java.vendor.url} System Property. Java vendor URL.
     */
    public static final String JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");

    /**
     * <p>
     * The {  java.version} System Property. Java version number.
     */
    public static final String JAVA_VERSION = getSystemProperty("java.version");

    /**
     * <p>
     * The {  java.vm.info} System Property. Java Virtual Machine implementation info.
     */
    public static final String JAVA_VM_INFO = getSystemProperty("java.vm.info");

    /**
     * <p>
     * The {  java.vm.name} System Property. Java Virtual Machine implementation name.*/
    public static final String JAVA_VM_NAME = getSystemProperty("java.vm.name");

    /**
     * <p>
     * The {  java.vm.specification.name} System Property. Java Virtual Machine specification name.
     */
    public static final String JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");

    /**
     * <p>
     * The {  java.vm.specification.vendor} System Property. Java Virtual Machine specification vendor.
     */
    public static final String JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");

    /**
     * <p>
     * The {  java.vm.specification.version} System Property. Java Virtual Machine specification version.
     */
    public static final String JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");

    /**
     * <p>
     * The {  java.vm.vendor} System Property. Java Virtual Machine implementation vendor.
     */
    public static final String JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");

    /**
     * <p>
     * The {  java.vm.version} System Property. Java Virtual Machine implementation version.
     */
    public static final String JAVA_VM_VERSION = getSystemProperty("java.vm.version");

    /**
     * The {  line.separator} System Property. Line separator (<code>&quot;\n&quot;</code> on UNIX).
     */
    @Deprecated
    public static final String LINE_SEPARATOR = getSystemProperty("line.separator");

    /**
     * <p>
     * The {  os.arch} System Property. Operating system architecture.
     */
    public static final String OS_ARCH = getSystemProperty("os.arch");

    /**
     * <p>
     * The {  os.name} System Property. Operating system name.
     */
    public static final String OS_NAME = getSystemProperty("os.name");

    /**
     * <p>
     * The {  os.version} System Property. Operating system version.
     */
    public static final String OS_VERSION = getSystemProperty("os.version");

    /**
     * <p>
     * The {  path.separator} System Property. Path separator (<code>&quot;:&quot;</code> on UNIX).
     */
    @Deprecated
    public static final String PATH_SEPARATOR = getSystemProperty("path.separator");

    /**
     * The {  user.country} or {  user.region} System Property. User's country code, such as {  GB}. First
     * in Java version 1.2 as {   user.region}. Renamed to {  user.country} in 1.4
     */
    public static final String USER_COUNTRY = getSystemProperty("user.country") == null ?
            getSystemProperty("user.region") : getSystemProperty("user.country");

    /**
     * The {  user.dir} System Property. User's current working directory.
     */
    public static final String USER_DIR = getSystemProperty(USER_DIR_KEY);

    /**
     * The {  user.home} System Property. User's home directory.
     */
    public static final String USER_HOME = getSystemProperty(USER_HOME_KEY);

    /**
     * The {  user.language} System Property. User's language code, such as {  "en"}.
     */
    public static final String USER_LANGUAGE = getSystemProperty("user.language");

    /**
     * The {  user.name} System Property. User's account name.
     */
    public static final String USER_NAME = getSystemProperty("user.name");

    /**
     * The {  user.timezone} System Property. For example: {  "America/Los_Angeles"}.
     */
    public static final String USER_TIMEZONE = getSystemProperty("user.timezone");

    // Java version checks
    // -----------------------------------------------------------------------
    // These MUST be declared after those above as they depend on the
    // values being set up

    /**
     * Is {  true} if this is Java version 1.1 (also 1.1.x versions).
     */
    public static final boolean IS_JAVA_1_1 = getJavaVersionMatches("1.1");

    /**
     * Is {  true} if this is Java version 1.2 (also 1.2.x versions).
     */
    public static final boolean IS_JAVA_1_2 = getJavaVersionMatches("1.2");

    /**
     * Is {  true} if this is Java version 1.3 (also 1.3.x versions).
     */
    public static final boolean IS_JAVA_1_3 = getJavaVersionMatches("1.3");

    /**
     * <p>
     * Is {  true} if this is Java version 1.4 (also 1.4.x versions).
     */
    public static final boolean IS_JAVA_1_4 = getJavaVersionMatches("1.4");

    /**
     * Is {  true} if this is Java version 1.5 (also 1.5.x versions).
     */
    public static final boolean IS_JAVA_1_5 = getJavaVersionMatches("1.5");

    /**
     * <p>
     * Is {  true} if this is Java version 1.6 (also 1.6.x versions).
     */
    public static final boolean IS_JAVA_1_6 = getJavaVersionMatches("1.6");

    /**
     * Is {  true} if this is Java version 1.7 (also 1.7.x versions).
     */
    public static final boolean IS_JAVA_1_7 = getJavaVersionMatches("1.7");

    /**
     * <p>
     * Is {  true} if this is Java version 1.8 (also 1.8.x versions).
     */
    public static final boolean IS_JAVA_1_8 = getJavaVersionMatches("1.8");

    /**
     * Is {  true} if this is Java version 1.9 (also 1.9.x versions).
     */
    @Deprecated
    public static final boolean IS_JAVA_1_9 = getJavaVersionMatches("9");

    /**
     * Is {  true} if this is Java version 9 (also 9.x versions).
     */
    public static final boolean IS_JAVA_9 = getJavaVersionMatches("9");

    /**
     * Is {  true} if this is Java version 10 (also 10.x versions).
     */
    public static final boolean IS_JAVA_10 = getJavaVersionMatches("10");

    // Operating system checks
    // -----------------------------------------------------------------------
    // These MUST be declared after those above as they depend on the
    // values being set up
    // OS names from http://www.vamphq.com/os.html
    // Selected ones included - please advise dev@commons.apache.org
    // if you want another added or a mistake corrected

    /**
     * Is {  true} if this is AIX.
     */
    public static final boolean IS_OS_AIX = getOSMatchesName("AIX");

    /**
     * Is {  true} if this is HP-UX.
     */
    public static final boolean IS_OS_HP_UX = getOSMatchesName("HP-UX");

    /**
     * Is {  true} if this is IBM OS/400.
     */
    public static final boolean IS_OS_400 = getOSMatchesName("OS/400");

    /**
     * Is {  true} if this is Irix.
     */
    public static final boolean IS_OS_IRIX = getOSMatchesName("Irix");

    /**
     * Is {  true} if this is Linux.
     * The field will return {  false} if {  OS_NAME} is {  null}.
     * @since 2.0
     */
    public static final boolean IS_OS_LINUX = getOSMatchesName("Linux") || getOSMatchesName("LINUX");

    /**
     * Is {  true} if this is Mac.
     */
    public static final boolean IS_OS_MAC = getOSMatchesName("Mac");

    /**
     * Is {  true} if this is Mac.
     */
    public static final boolean IS_OS_MAC_OSX = getOSMatchesName("Mac OS X");

    /**
     * Is {  true} if this is Mac OS X Cheetah.
     */
    public static final boolean IS_OS_MAC_OSX_CHEETAH = getOSMatches("Mac OS X", "10.0");

    /**
     * Is {  true} if this is Mac OS X Puma.
     */
    public static final boolean IS_OS_MAC_OSX_PUMA = getOSMatches("Mac OS X", "10.1");

    /**
     * Is {  true} if this is Mac OS X Jaguar.
     */
    public static final boolean IS_OS_MAC_OSX_JAGUAR = getOSMatches("Mac OS X", "10.2");

    /**
     * Is {  true} if this is Mac OS X Panther.
     */
    public static final boolean IS_OS_MAC_OSX_PANTHER = getOSMatches("Mac OS X", "10.3");

    /**
     * Is {  true} if this is Mac OS X Tiger.
     */
    public static final boolean IS_OS_MAC_OSX_TIGER = getOSMatches("Mac OS X", "10.4");

    /**
     * Is {  true} if this is Mac OS X Leopard.
     */
    public static final boolean IS_OS_MAC_OSX_LEOPARD = getOSMatches("Mac OS X", "10.5");

    /**
     * Is {  true} if this is Mac OS X Snow Leopard.
     */
    public static final boolean IS_OS_MAC_OSX_SNOW_LEOPARD = getOSMatches("Mac OS X", "10.6");

    /**
     * Is {  true} if this is Mac OS X Lion.
     */
    public static final boolean IS_OS_MAC_OSX_LION = getOSMatches("Mac OS X", "10.7");

    /**
     * Is {  true} if this is Mac OS X Mountain Lion.
     */
    public static final boolean IS_OS_MAC_OSX_MOUNTAIN_LION = getOSMatches("Mac OS X", "10.8");

    /**
     * Is {  true} if this is Mac OS X Mavericks.
     * The field will return {  false} if {  OS_NAME} is {  null}.
     * @since 3.4
     */
    public static final boolean IS_OS_MAC_OSX_MAVERICKS = getOSMatches("Mac OS X", "10.9");

    /**
     * Is {  true} if this is Mac OS X Yosemite.
     */
    public static final boolean IS_OS_MAC_OSX_YOSEMITE = getOSMatches("Mac OS X", "10.10");

    /**
     * Is {  true} if this is Mac OS X El Capitan.
     */
    public static final boolean IS_OS_MAC_OSX_EL_CAPITAN = getOSMatches("Mac OS X", "10.11");

    /**
     * Is {  true} if this is FreeBSD.
     */
    public static final boolean IS_OS_FREE_BSD = getOSMatchesName("FreeBSD");

    /**
     * Is {  true} if this is OpenBSD.
     */
    public static final boolean IS_OS_OPEN_BSD = getOSMatchesName("OpenBSD");

    /**
     * Is {  true} if this is NetBSD.
     */
    public static final boolean IS_OS_NET_BSD = getOSMatchesName("NetBSD");

    /**
     * Is {  true} if this is OS/2.
     */
    public static final boolean IS_OS_OS2 = getOSMatchesName("OS/2");

    /**
     * Is {  true} if this is Solaris.
     */
    public static final boolean IS_OS_SOLARIS = getOSMatchesName("Solaris");

    /**
     * Is {  true} if this is SunOS.
     */
    public static final boolean IS_OS_SUN_OS = getOSMatchesName("SunOS");

    /**
     * Is {  true} if this is a UNIX like system, as in any of AIX, HP-UX, Irix, Linux, MacOSX, Solaris or SUN OS.
     */
    public static final boolean IS_OS_UNIX = IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX
            || IS_OS_SOLARIS || IS_OS_SUN_OS || IS_OS_FREE_BSD || IS_OS_OPEN_BSD || IS_OS_NET_BSD;

    /**
     * Is {  true} if this is Windows.
     */
    public static final boolean IS_OS_WINDOWS = getOSMatchesName(OS_NAME_WINDOWS_PREFIX);

    /**
     * Is {  true} if this is Windows 2000.
     */
    public static final boolean IS_OS_WINDOWS_2000 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 2000");

    /**
     * Is {  true} if this is Windows 2003.
     */
    public static final boolean IS_OS_WINDOWS_2003 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 2003");

    /**
     * Is {  true} if this is Windows Server 2008.
     */
    public static final boolean IS_OS_WINDOWS_2008 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Server 2008");

    /**
     * Is {  true} if this is Windows Server 2012.
     */
    public static final boolean IS_OS_WINDOWS_2012 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Server 2012");

    /**
     * Is {  true} if this is Windows 95.
     */
    public static final boolean IS_OS_WINDOWS_95 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 95");

    /**
     * Is {  true} if this is Windows 98.
     */
    public static final boolean IS_OS_WINDOWS_98 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 98");

    /**
     * Is {  true} if this is Windows ME.
     * The field will return {  false} if {  OS_NAME} is {  null}.
     */
    public static final boolean IS_OS_WINDOWS_ME = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Me");

    /**
     * Is {  true} if this is Windows NT.
     */
    public static final boolean IS_OS_WINDOWS_NT = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " NT");

    /**
     * Is {  true} if this is Windows XP.
     */
    public static final boolean IS_OS_WINDOWS_XP = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " XP");

    // -----------------------------------------------------------------------
    /**
     * Is {  true} if this is Windows Vista.
     */
    public static final boolean IS_OS_WINDOWS_VISTA = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " Vista");

    /**
     * Is {  true} if this is Windows 7.
     */
    public static final boolean IS_OS_WINDOWS_7 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 7");

    /**
     * Is {  true} if this is Windows 8.
     */
    public static final boolean IS_OS_WINDOWS_8 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 8");

    /**
     * Is {  true} if this is Windows 10.
     */
    public static final boolean IS_OS_WINDOWS_10 = getOSMatchesName(OS_NAME_WINDOWS_PREFIX + " 10");

    /**
     * Is {  true} if this is z/OS.
     */
    // Values on a z/OS system I tested (Gary Gregory - 2016-03-12)
    // os.arch = s390x
    // os.encoding = ISO8859_1
    // os.name = z/OS
    // os.version = 02.02.00
    public static final boolean IS_OS_ZOS = getOSMatchesName("z/OS");

    /**
     * Gets the Java home directory as a {  File}.
     * @return result
     */
    public static File getJavaHome() {
        return new File(System.getProperty(JAVA_HOME_KEY));
    }

    /**
     * Gets the host name from an environment variable.
     * @return result
     */
    public static String getHostName() {
        return SystemUtils.IS_OS_WINDOWS ? System.getenv("COMPUTERNAME") : System.getenv("HOSTNAME");
    }

    /**
     * Gets the Java IO temporary directory as a {  File}.
     * @return result
     */
    public static File getJavaIoTmpDir() {
        return new File(System.getProperty(JAVA_IO_TMPDIR_KEY));
    }


    /**
     * Decides if the operating system matches.
     * @param osNamePrefix the prefix for the os name
     * @param osVersionPrefix the prefix for the version
     * @return true if matches, or false if not or can't determine
     */
    private static boolean getOSMatches(final String osNamePrefix, final String osVersionPrefix) {
        return isOSMatch(OS_NAME, OS_VERSION, osNamePrefix, osVersionPrefix);
    }

    private static boolean getJavaVersionMatches(final String versionPrefix) {
        return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, versionPrefix);
    }

    /**
     * Decides if the operating system matches.
     * @param osNamePrefix the prefix for the os name
     * @return true if matches, or false if not or can't determine
     */
    private static boolean getOSMatchesName(final String osNamePrefix) {
        return isOSNameMatch(OS_NAME, osNamePrefix);
    }

    // -----------------------------------------------------------------------
    /**
     * Gets a System property, defaulting to {  null} if the property cannot be read.
     */
    private static String getSystemProperty(final String property) {
        try {
            return System.getProperty(property);
        } catch (final SecurityException ex) {
            // we are not allowed to look at this property
            System.err.println("Caught a SecurityException reading the system property '" + property
                    + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    /**
     * Gets the user directory as a {  File}.
     * @return result
     */
    public static File getUserDir() {
        return new File(System.getProperty(USER_DIR_KEY));
    }

    /**
     * Gets the user home directory as a {  File}.
     * @return a directory
     * @throws SecurityException if a security manager exists and its {  checkPropertyAccess} method doesn't allow
     * access to the specified system property.
     * @see System#getProperty(String)
     * @since 2.1
     */
    public static File getUserHome() {
        return new File(System.getProperty(USER_HOME_KEY));
    }

    public static String getSysPath() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        String temp = path.replaceFirst("file:/", "").replaceFirst(
                "WEB-INF/classes/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        String temp = path.replaceFirst("file:/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }


    /**
     * Returns whether the {@link #JAVA_AWT_HEADLESS} value is {  true}.
     *
     * @return {  true} if {  JAVA_AWT_HEADLESS} is {  "true"}, {  false} otherwise.
     */
    public static boolean isJavaAwtHeadless() {
        return Boolean.TRUE.toString().equals(JAVA_AWT_HEADLESS);
    }


    /**
     * Decides if the Java version matches.
     * This method is package private instead of private to support unit test invocation.
     * @param version the actual Java version
     * @param versionPrefix the prefix for the expected Java version
     * @return true if matches, or false if not or can't determine
     */
    static boolean isJavaVersionMatch(final String version, final String versionPrefix) {
        if (version == null) {
            return false;
        }
        return version.startsWith(versionPrefix);
    }

    /**
     * Decides if the operating system matches.
     * This method is package private instead of private to support unit test invocation.
     * @param osName the actual OS name
     * @param osVersion the actual OS version
     * @param osNamePrefix the prefix for the expected OS name
     * @param osVersionPrefix the prefix for the expected OS version
     * @return true if matches, or false if not or can't determine
     */
    static boolean isOSMatch(final String osName, final String osVersion, final String osNamePrefix, final String osVersionPrefix) {
        if (osName == null || osVersion == null) {
            return false;
        }
        return isOSNameMatch(osName, osNamePrefix) && isOSVersionMatch(osVersion, osVersionPrefix);
    }

    /**
     * Decides if the operating system matches.
     * This method is package private instead of private to support unit test invocation.
     * @param osName the actual OS name
     * @param osNamePrefix the prefix for the expected OS name
     * @return true if matches, or false if not or can't determine
     */
    static boolean isOSNameMatch(final String osName, final String osNamePrefix) {
        if (osName == null) {
            return false;
        }
        return osName.startsWith(osNamePrefix);
    }

    /**
     * Decides if the operating system version matches.
     * This method is package private instead of private to support unit test invocation.
     * @param osVersion the actual OS version
     * @param osVersionPrefix the prefix for the expected OS version
     * @return true if matches, or false if not or can't determine
     */
    static boolean isOSVersionMatch(final String osVersion, final String osVersionPrefix) {
        if (StringUtils.isEmpty(osVersion)) {
            return false;
        }
        // Compare parts of the version string instead of using String.startsWith(String) because otherwise
        // osVersionPrefix 10.1 would also match osVersion 10.10
        final String[] versionPrefixParts = osVersionPrefix.split("\\.");
        final String[] versionParts = osVersion.split("\\.");
        for (int i = 0; i < Math.min(versionPrefixParts.length, versionParts.length); i++) {
            if (!versionPrefixParts[i].equals(versionParts[i])) {
                return false;
            }
        }
        return true;
    }

    // -----------------------------------------------------------------------
    /**
     * SystemUtils instances should NOT be constructed in standard programming. Instead, the class should be used as
     */
    public SystemUtils() {
        super();
    }

}
