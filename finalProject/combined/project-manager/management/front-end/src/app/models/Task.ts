import { Project } from './Project';
import {User} from './User';

export class Task{
  taskId: 0;
  taskName:'';
  startDate:'';
  estimatedEndDate:'';
  description:'';
  project=new Project();
  employee=new User();
  userId:0;
  projectId:0;

}
