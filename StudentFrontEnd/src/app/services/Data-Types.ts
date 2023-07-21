export interface Course {
    courseId:number;
    name: string;
    description: string;
    maxNumberOfStudents: number;
    teacher: string;
}

export interface Student {
    userId:number;
    userFirstName:string;
    userLastName:string;
    email:string;
}