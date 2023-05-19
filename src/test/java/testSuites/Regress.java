package testSuites;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("chrome")
@IncludeClassNamePatterns(".*Test")
@IncludeTags("reg")
public class Regress {
}
