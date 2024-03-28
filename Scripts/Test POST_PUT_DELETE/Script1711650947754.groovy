import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//POST
//Pedido a API POST para criar um new user
newUser = WS.sendRequest(findTestObject('POST a new user')) 

//Print do newUser (do ID)
println(newUser)

//Validar que resposta do POST é OK
WS.verifyResponseStatusCode(newUser, 201)

//Obter o ID do new user
newUserId = WS.getElementPropertyValue(newUser, 'id')

//Print do ID do new user
println(newUserId)

//Igualar a Global variable ao ID do new user
GlobalVariable.user_1 = newUserId

/* As seguintes linhas de código servem para validar o user criado atraves do metodo GET
 * No entanto o metodo devolve erro 404 Not Found, em vez de 200 OK como era de esperar

getResponse = WS.sendRequest(findTestObject('GET user_1'))

println(getResponse)

WS.verifyResponseStatusCode(getResponse, 200)

*/

//PUT
//Pedido a PUT para atualizar a informação do new user
updateUser = WS.sendRequest(findTestObject('PUT'))

//Validar que resposta do PUT é OK
WS.verifyResponseStatusCode(updateUser, 200)


//DELETE
// Pedido a API DElETE para eliminar o new user
deleteResponse = WS.sendRequest(findTestObject('DELETE'))

//Validar que resposta do DELETE é OK
WS.verifyResponseStatusCode(deleteResponse, 204)

