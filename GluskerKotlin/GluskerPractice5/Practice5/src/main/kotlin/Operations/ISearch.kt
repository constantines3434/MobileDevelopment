package Operations

import MyBase.DataBase

interface ISearch
{
   fun SearchOperationsByDescription(search: String): List<DataBase>
}