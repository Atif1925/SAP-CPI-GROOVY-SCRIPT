/*
 * Introduction to Groovy for SAP CPI
 *
 * Why Groovy in SAP CPI?
 * - Used for scripting in integration flows (e.g., message transformation, conditional routing, custom logic).
 * - Lightweight syntax compared to Java.
 * - Direct access to CPI’s `Message` object and its APIs.
 */

/*
 * Basic Groovy Syntax (Java vs. Groovy)
 *
 * Key Differences from Java
 *
 * 1. Optional Semicolons: Semicolons are optional in Groovy.
 */
def name = "CPI"  // No semicolon needed

/*
 * 2. Dynamic Typing: Use `def` for variables (type inferred at runtime).
 */
def dynamicVar = "Hello"  // String
dynamicVar = 42  // Now an Integer

/*
 * 3. Script Structure: No need for a class or `public static void main` in scripts.
 */
println "Hello SAP CPI"  // Directly executable

/*
 * Data Types and Collections
 *
 * Primitive and Object Types
 * - Groovy autoboxes primitives (e.g., `int` becomes `Integer`).
 * - Strings:
 *   - Single quotes ('...'): Plain String (like Java).
 *   - Double quotes ("..."): Allows interpolation with `${}`.
 */
def name = "CPI"
println "Hello ${name}"  // Output: Hello CPI

/*
 * Collections (Lists, Maps)
 *
 * Lists:
 */
def list = [1, 2, 3]
list << 4  // Add element
println list[1]  // Output: 2 (0-based index)

/*
 * Maps:
 */
def map = [key1: "value1", key2: "value2"]
println map.key1  // Output: value1

/*
 * Closures (Key Groovy Feature)
 *
 * What is a Closure? A block of code that can be assigned to a variable or passed as an argument (similar to Java lambdas).
 */
def greet = { name -> println "Hello ${name}" }
greet("CPI")  // Output: Hello CPI

/*
 * Use in Collections:
 */
def numbers = [1, 2, 3]
numbers.each { println it }  // "it" is the default parameter

/*
 * Working with Strings
 *
 * Multi-line Strings:
 */
def xmlPayload = '''
<root>
  <id>123</id>
</root>
'''

/*
 * String Interpolation:
 */
def id = 123
def message = "ID is ${id}"

/*
 * Handling XML/JSON in Groovy (Critical for CPI)
 *
 * Parsing XML:
 */
def xmlText = "<root><id>123</id></root>"
def rootNode = new XmlSlurper().parseText(xmlText)
println rootNode.id  // Output: 123

/*
 * Generating XML:
 */
def builder = new groovy.xml.XmlSlurper()
def root = builder.root
root.id(123)
println groovy.xml.XmlUtil.serialize(root)

/*
 * JSON Handling:
 */
import groovy.json.JsonSlurper
def jsonText = '{"id": 123}'
def json = new JsonSlurper().parseText(jsonText)
println json.id  // Output: 123
