package testSuites;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("chrome")
@IncludeClassNamePatterns(".*Test")
@IncludeTags("smoke")
public class Smoke {
}
