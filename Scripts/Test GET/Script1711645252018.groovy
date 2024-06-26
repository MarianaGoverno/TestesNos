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
//GET

//Obter a resposta da API GET users
getUsersResponse = WS.sendRequest(findTestObject('GET users'))

//Obter os IDs dos users 
userId = WS.getElementPropertyValue(getUsersResponse, 'id')

//Print dos IDs 
println(userId)

// Gerar um numero random
def randomIndex = new Random().nextInt(userId.size())

// Obter valor do ID random
def randomValue = userId[randomIndex]

//Print do ID 
println(randomValue)

//Igualar a Global variable ao ID obtido
GlobalVariable.user_1 = randomValue

//Resposta da API GET user_1
getUser1 = WS.sendRequest(findTestObject('GET user_1'))

//Obter o ID do user1
user1Id = WS.getElementPropertyValue(getUser1, 'id')

//Print do user_1
println(user1Id)

//Verificar que o ID random e o ID do user_1 são iguais
WebUI.verifyEqual(user1Id, randomValue)

