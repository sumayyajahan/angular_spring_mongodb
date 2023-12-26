import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent {

  StudentArray : any[] = [];
  student_name: string = "";
  student_address: string = "";
  mobile: Number = 0; 
  currentStudentID = "";

  constructor(private http: HttpClient){
    this.getAllStudent();
  }

  register()
  {
  
    let bodyData = {
      "student_name" : this.student_name,
      "student_address" : this.student_address,
      "mobile" : this.mobile
    };
 
    this.http.post("http://localhost:8089/api/v1/student/save",bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Student Registered Successfully");
        this.getAllStudent();
        this.student_name = '';
        this.student_address = '';
        this.mobile = 0;
    });
  }


getAllStudent()
{
  
  this.http.get("http://localhost:8089/api/v1/student/getAll")

  .subscribe((resultData: any)=>
  {
  
      console.log(resultData);
      this.StudentArray = resultData;
  });
}

setUpdate(data: any)
  {
   this.student_name = data.student_name;
   this.student_address = data.student_address;
   this.mobile = data.mobile;
   this.currentStudentID = data.id;
   console.log("data = ");
   console.log(data);
   console.log(this.currentStudentID);
  }

  UpdateRecords()
  {
    let bodyData = {
      "_id" : this.currentStudentID,
      "student_name" : this.student_name,
      "student_address" : this.student_address,
      "mobile" : this.mobile
    };
    
    this.http.put("http://localhost:8089/api/v1/student/edit"+ "/" + this.currentStudentID , bodyData,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Student Registered Updated")
        this.getAllStudent();
        this.student_name = '';
        this.student_address = '';
        this.mobile  = 0;
    });
  }
 
  save()
  {
    if(this.currentStudentID == '')
    {
        this.register();
    }
      else
      {
       this.UpdateRecords();
      }      
 
  }
 
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8089/api/v1/student/delete"+ "/"+ data.id,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Student Deleted")
        this.getAllStudent();
 
        this.student_name = '';
        this.student_address = '';
        this.mobile  = 0;
  
    });
 
  }

}

