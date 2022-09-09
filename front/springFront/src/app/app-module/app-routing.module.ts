import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AddMessageComponent  } from '../components/message/add-message/add-message.component';
import { MessageListComponent} from '../components/message/message-list/message-list.component';
import { MessageDetailsComponent } from '../components/message/message-details/message-details.component';

import { AddUtilisateurComponent } from '../components/utilisateurs/add-utilisateur/add-utilisateur.component';
import { UtilisateurDetailsComponent } from '../components/utilisateurs/utilisateur-details/utilisateur-details.component';
import { UtilisateurListComponent } from '../components/utilisateurs/utilisateur-list/utilisateur-list.component';

const routes: Routes = [
  {path: 'messages_page', redirectTo: 'messages', pathMatch: 'full'},
  {path: 'messages', component: MessageListComponent},
  {path: 'messages/:id', component:MessageDetailsComponent},
  {path: 'messages/add', component:AddMessageComponent},

  {path: 'utilisateurs_page', redirectTo: 'utilisateurs', pathMatch: 'full'},
  {path: 'utilisateurs', component: UtilisateurListComponent},
  {path: 'utilisateurs/:id',component:UtilisateurDetailsComponent},
  {path: 'utilisateurs/add', component:AddMessageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
